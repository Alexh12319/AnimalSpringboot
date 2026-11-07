package com.Ejercicio._Prueba.interfaces;


import com.Ejercicio._Prueba.models.Animal;

import java.util.ArrayList;


public interface AnimalService {

    ArrayList<Animal> getAnimals();

    Animal getAnimal(int id);

    Animal addAnimal(Animal a);

    Animal editAnimal(Animal act);

    boolean deleteAnimal(int id);
}

