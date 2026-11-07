package com.Ejercicio._Prueba.service;

import com.Ejercicio._Prueba.interfaces.FamilyService;
import com.Ejercicio._Prueba.models.Family;
import com.Ejercicio._Prueba.repository.FamilyRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Profile("database")
public class FamilyServiceImp implements FamilyService {

    private final FamilyRepository familyRepository;

    public FamilyServiceImp(FamilyRepository familyRepository){
        this.familyRepository = familyRepository;
    }
    @Override
    public ArrayList<Family> getFamilies() {
        return new ArrayList<>(familyRepository.findAll());
    }

    @Override
    public Family getFamily(int id) {
        return familyRepository.findById(id).orElse(null);
    }

    @Override
    public Family addFamily(Family f) {
        return familyRepository.save(f);
    }

    @Override
    public Family editFamily(Family f) {
        if(familyRepository.existsById(f.getId())) {
            return familyRepository.save(f);
        }

        return null;
    }

    @Override
    public boolean deleteFamily(int id) {
        if (familyRepository.existsById(id)) {
            familyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
