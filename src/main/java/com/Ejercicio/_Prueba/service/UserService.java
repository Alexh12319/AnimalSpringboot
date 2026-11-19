package com.Ejercicio._Prueba.service;


import com.Ejercicio._Prueba.models.User;
import com.Ejercicio._Prueba.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByemail(username).orElseThrow(() -> new UsernameNotFoundException("Ususario no encontrado"));
                    //Lo SACA DE LA BD                    o da error y lanza excepcion

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

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






}
