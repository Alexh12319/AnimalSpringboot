package com.Ejercicio._Prueba.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Animal {
    int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    String name;
    @Positive(message = "La vida media no puede ser negativa o 0")
    int averageLifeSpan;
    boolean extinct;

    public Animal(){}

    public Animal(int id, String name, int averageLifeSpan, boolean extinct){
        this.id = id;
        this.name = name;
        this.averageLifeSpan = averageLifeSpan;
        this.extinct = extinct;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAverageLifeSpan(){
        return averageLifeSpan;
    }

    public boolean getExtinct(){
        return extinct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAverageLifeSpan(int averageLifeSpan) {
        this.averageLifeSpan = averageLifeSpan;
    }

    public void setExtinct(boolean extinct) {
        this.extinct = extinct;
    }

    @Override
    public String toString() {
        return "id: " + id + " Name: " + name + " Average life span: " + averageLifeSpan + " extinct: " + extinct;
    }
}
