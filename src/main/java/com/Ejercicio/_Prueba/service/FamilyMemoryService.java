package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.models.Family;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Profile("memory")
public class FamilyMemoryService implements FamilyService {
    ArrayList<Family> families = new ArrayList<>();
    int familyCount = 0;

    @Override
    public ArrayList<Family> getFamilies() {
        return families;
    }

    @Override
    public Family getFamily(int id) {
        Family littleFamily = new Family();
        for(int i = 0; i < families.size(); i++){
            if(families.get(i).getId() == id) {
                littleFamily = families.get(i);
            }
        }
        return littleFamily;
    }

    @Override
    public Family addFamily(Family f) {
        familyCount ++;
        f.setId(familyCount);
        families.add(f);
        return f;
    }

    @Override
    public Family editFamily(Family newFamily) {
        boolean encontrado = false;
        Family lastFamily = null;
        for(int i = 0; i < families.size(); i++){
            if(newFamily.getId() == families.get(i).getId()){
                lastFamily = families.get(i);
                encontrado = true;
            }
        }
        if(encontrado){
            lastFamily.setName(newFamily.getName());
        }
        return lastFamily;
    }


    @Override
    public boolean deleteFamily(int id) {
        boolean eliminado = false;
        Family littleFamily = new Family();
        for(int i = 0; i < families.size(); i++){
            if(families.get(i).getId() == id) {
                littleFamily = families.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }
}
