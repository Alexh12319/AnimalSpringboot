package com.Ejercicio._Prueba.service;
import com.Ejercicio._Prueba.models.Animal;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnimalService {
    ArrayList<Animal> animales = new ArrayList<>(
            Arrays.asList(new Animal(1, "Dodo", 50, true), new Animal(2, "Perro", 10, false)));
    int animalsCount = 2; //Al poner dos antes, lo inicializo en dos

    public ArrayList<Animal> getAnimals(){
        return animales;
    }

    public Animal getAnimal(int id){
        Animal animalin = new Animal();
        for(int i = 0; i < animales.size(); i++){
            if(animales.get(i).getId() == id) {
                animalin = animales.get(i);
            }
        }
        return animalin;
    }

    public Animal addAnimal(Animal a){
        animalsCount ++;
        a.setId(animalsCount);
        animales.add(a);
        return a;
    }

    public Animal editAnimal(Animal act){
        boolean encontrado = false;
        Animal animalAnterior = null;
        for(int i = 0; i < animales.size(); i++){
            if(act.getId() == animales.get(i).getId()){
                animalAnterior = animales.get(i);
                encontrado = true;
            }
        }

        if(encontrado){
            animalAnterior.setExtinct(act.getExtinct());
            animalAnterior.setAverageLifeSpan(act.getAverageLifeSpan());
            animalAnterior.setName(act.getName());
        }
        return animalAnterior;
    }

    public boolean deleteAnimal(int id){
        boolean eliminado = false;
        Animal animalin = new Animal();
        for(int i = 0; i < animales.size(); i++){
            if(animales.get(i).getId() == id) {
                animalin = animales.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }
}
