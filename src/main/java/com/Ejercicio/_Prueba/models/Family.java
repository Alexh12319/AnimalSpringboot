package com.Ejercicio._Prueba.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //MySql genera el ID automaticamente
    private int id;
    private String name;
    @OneToMany(mappedBy = "family",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Animal> animals;

    public Family(){

    }


    public Family(int id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
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
