package com.Ejercicio._Prueba.config;

import com.Ejercicio._Prueba.models.Animal;
import com.Ejercicio._Prueba.repository.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseInitializr {

    @Bean
    CommandLineRunner initDatabase(AnimalRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Animal a1 = new Animal();
                a1.setName("Dodo");
                a1.setAverageLifeSpan(50);
                a1.setExtinct(true);

                Animal a2 = new Animal();
                a2.setName("Perro");
                a2.setAverageLifeSpan(10);
                a2.setExtinct(false);

                Animal a3 = new Animal();
                a3.setName("Gato");
                a3.setAverageLifeSpan(15);
                a3.setExtinct(false);

                repository.save(a1);
                repository.save(a2);
                repository.save(a3);
            }
        };
    }
}