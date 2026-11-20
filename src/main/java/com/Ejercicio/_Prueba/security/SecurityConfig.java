package com.Ejercicio._Prueba.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(authz -> authz
            .requestMatchers("/", "/login", "/register", "/css/**", "/img/**").permitAll()
            .anyRequest().authenticated()
    );
    http.formLogin(form -> form
            .loginPage("/")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .permitAll()
    );

    http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
    );
    
    return http.build();

    }


}
