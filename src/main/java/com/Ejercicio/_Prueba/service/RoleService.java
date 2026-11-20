package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.models.Role;
import com.Ejercicio._Prueba.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }


    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findByName(String name){
        return roleRepository.findByName(name);
    }

    public Role create(String name) {
        if (roleRepository.findByName(name).isPresent()) { //Basicamente es como "Si ya existe"
            throw new IllegalArgumentException("El rol " + name + " ya existe");
        }
        return roleRepository.save(new Role(name));
    }


}
