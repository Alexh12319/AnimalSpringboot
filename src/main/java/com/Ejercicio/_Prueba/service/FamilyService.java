package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.models.Family;

import java.util.ArrayList;


public interface FamilyService {

    ArrayList<Family> getFamilies();

    Family getFamily(int id);

    Family addFamily(Family f);

    Family editFamily(Family f);

    boolean deleteFamily(int id);
}

