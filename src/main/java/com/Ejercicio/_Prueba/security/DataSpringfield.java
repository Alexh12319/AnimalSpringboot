package com.Ejercicio._Prueba.security;

import com.Ejercicio._Prueba.models.Role;
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

    UserService userService;

    public DataSpringfield(RoleRepository roleRepository, UserRepository userRepository, UserService userService){
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


            if((userRepository.findByemail("user@springfield.com").isEmpty())){
                userService.createUser("Usuario", "Springfield", "user123","user@springfield.com", "ROLE_USER");
            }

            if((userRepository.findByemail("admin@springfield.com").isEmpty())){
                userService.createUser("Admin", "Springfield", "admin123", "admin@springfield.com", "ROLE_ADMIN");
            }



        };

    }
}
