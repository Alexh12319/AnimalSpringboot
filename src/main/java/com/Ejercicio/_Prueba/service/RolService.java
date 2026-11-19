package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.models.Role;
import com.Ejercicio._Prueba.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {


    private final RoleRepository roleRepository;

    public RolService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }



    //TODO: Listar roles por lista
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findByName(String name){
        return roleRepository.findByName(name);
    }

    public Role create(String name) {
        if (roleRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("El rol " + name + " ya existe");
        }
        return roleRepository.save(new Role(name));
    }


}
