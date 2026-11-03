package com.Ejercicio._Prueba.repository;

import com.Ejercicio._Prueba.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}