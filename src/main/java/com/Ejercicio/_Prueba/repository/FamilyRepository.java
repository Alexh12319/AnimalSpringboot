package com.Ejercicio._Prueba.repository;

import com.Ejercicio._Prueba.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Integer> {

}