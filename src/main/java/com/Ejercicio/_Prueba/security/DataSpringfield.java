package com.Ejercicio._Prueba.security;

import com.Ejercicio._Prueba.models.Role;
import com.Ejercicio._Prueba.service.RolService;
import com.Ejercicio._Prueba.repository.RoleRepository;
import com.Ejercicio._Prueba.repository.UserRepository;
import com.Ejercicio._Prueba.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSpringfield {
    RoleRepository roleRepository;
    UserRepository userRepository;

    RolService roleService;
    UserService userService;

    public DataSpringfield(RoleRepository roleRepository, RolService roleService, UserRepository userRepository, UserService userService){
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Bean
    public CommandLineRunner fieldData(){

        return args -> {
            if(roleRepository.findByName("ROLE_USER").isEmpty()) {
                roleRepository.save(new Role("ROLE_USER"));
            }

            if(roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
                roleRepository.save(new Role("ROLE_ADMIN"));
            }

            Role roleUser = roleService.findByName("ROLE_USER").orElseThrow();

            /* TODO: HACER UNA VEZ HECHO EL crear usuario EN EL USER SERVICE
            if(!(userRepository.findByemail("user@springfield.com").isPresent())){
                //TODO: Aqui crear ususario del service
            }
            */

            Role roleAdmin = roleService.findByName("ROLE_ADMIN").orElseThrow();
        };

    }
}
