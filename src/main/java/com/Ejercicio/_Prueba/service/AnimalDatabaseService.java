package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.models.Animal;
import com.Ejercicio._Prueba.repository.AnimalRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Profile("database")
public class AnimalDatabaseService implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalDatabaseService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public ArrayList<Animal> getAnimals() {
        return new ArrayList<>(animalRepository.findAll());
    }

    @Override
    public Animal getAnimal(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public Animal addAnimal(Animal a) {
        return animalRepository.save(a);
    }

    @Override
    public Animal editAnimal(Animal act) {
        if (animalRepository.existsById(act.getId())) {
            return animalRepository.save(act);
        }

        return null;
    }

    @Override
    public boolean deleteAnimal(int id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}