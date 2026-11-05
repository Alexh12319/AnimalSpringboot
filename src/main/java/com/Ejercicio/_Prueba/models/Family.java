package com.Ejercicio._Prueba.models;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //MySql genera el ID automaticamente
    private int id;
    private String name;
    @OneToMany(mappedBy = "animal",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private ArrayList<Animal> animals;

    public Family(int id, String name){
        this.id = id;
        this.name = name;
        animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " Family: " + " Id: " + id + " Name: " + name + " Animals: " + animals;
    }
}
