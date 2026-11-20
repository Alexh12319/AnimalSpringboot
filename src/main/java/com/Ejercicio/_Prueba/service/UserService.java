package com.Ejercicio._Prueba.service;


import com.Ejercicio._Prueba.models.Role;
import com.Ejercicio._Prueba.models.User;
import com.Ejercicio._Prueba.repository.UserRepository;
import com.Ejercicio._Prueba.exceptions.RoleNotFoundException;
//--------------------------------------------------
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByemail(username).orElseThrow(() -> new UsernameNotFoundException("Ususario no encontrado"));
                    //Lo SACA DE LA BD                    o da error y lanza excepcion

        List<SimpleGrantedAuthority> authorities = new ArrayList<>(); //Lista authorities

        for(int i = 0; i < user.getRoles().size(); i++){
            authorities.add(new SimpleGrantedAuthority(user.getRoles().get(i).getName()));
        }

        //authorities.add(new SimpleGrantedAuthority()); TODO user y admin

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }

    public User createUser(String nombre, String apellidos, String password, String email, String roleName) throws RoleNotFoundException {
        String cryptPassword = new BCryptPasswordEncoder().encode(password);
        User user = new User(nombre, apellidos, cryptPassword, email);
        Role role = roleService.findByName(roleName).orElseThrow(() -> new RoleNotFoundException("Rol no encontrado"));
        user.getRoles().add(role);
        return userRepository.save(user);
    }






}
