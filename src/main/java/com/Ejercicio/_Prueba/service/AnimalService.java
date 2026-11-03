package com.Ejercicio._Prueba.service;


import com.Ejercicio._Prueba.models.Animal;

import java.util.ArrayList;
import java.util.List;

public interface AnimalService {

    ArrayList<Animal> getAnimals();

    Animal getAnimal(int id);

    Animal addAnimal(Animal a);

    Animal editAnimal(Animal act);

    boolean deleteAnimal(int id);
}
>>>>>>> ccfbd7ccd5b89976a89941ab3ef7c5fd4a1876cd
