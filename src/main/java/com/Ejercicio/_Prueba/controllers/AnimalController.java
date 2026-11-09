package com.Ejercicio._Prueba.controllers;

import com.Ejercicio._Prueba.interfaces.FamilyService;
import com.Ejercicio._Prueba.models.Animal;
import com.Ejercicio._Prueba.interfaces.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

@Controller
public class AnimalController{

    @Autowired
    private AnimalService as;
    @Autowired
    private FamilyService fs;

    @GetMapping("/animals")
    public String animales(Model model) {
        model.addAttribute("animales", as.getAnimals());
        model.addAttribute("familias", fs.getFamilies());
        //También tengo que saber a que familia pertenece
        return "Animals/animals";
    }

    @GetMapping("animals/details/{id}")
    public String DetallesAnimal(@PathVariable int id, Model model) { //Model siempre al final
        Animal animal = as.getAnimal(id);
        String response = "redirect:/animals";
        if(animal != null){
            model.addAttribute("animal", animal);
            response = "Animals/details";
        }
        return response;
    }

    @GetMapping("/animals/create")
    public String crearAnimal(Model model){
        model.addAttribute("animal", new Animal());
        model.addAttribute("familias", fs.getFamilies());
        return "animals/create";
    }

    @PostMapping("/animals/create")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Animals/create";
        }else{
            if(animal.getFamily() != null && animal.getFamily().getId() == 0){
                animal.setFamily(null);
            }else if(animal.getFamily() != null){
                animal.setFamily(fs.getFamily(animal.getFamily().getId()));
            }
            as.addAnimal(animal);
            //return "/animals";
            return "redirect:/animals/details/" + animal.getId();
        }
    }

    @GetMapping("/animals/edit/{id}")
    public String EditarAnimal(Model model, @PathVariable int id){
        model.addAttribute("animal", as.getAnimal(id));
        model.addAttribute("familias", fs.getFamilies());
        return "Animals/edit";
    }

    @PostMapping("/animals/edit")
    public String EditarAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        String resultado = "redirect:/animals";
        if(bindingResult.hasErrors()){
            resultado = "Animals/edit";
        }else{
            if(animal.getFamily() != null && animal.getFamily().getId() == 0){
                animal.setFamily(null);
            }else if(animal.getFamily() != null){
                animal.setFamily(fs.getFamily(animal.getFamily().getId()));
            }
            as.editAnimal(animal);
        }
        return resultado;
    }
//------Queda eliminar
    @GetMapping("/animals/delete/{id}")
    public String borrarAnimal(Model model, @PathVariable int id){
        model.addAttribute("animal", as.getAnimal(id)); //Recibe animal
        return "Animals/delete";
    }

    @PostMapping("/animals/delete")
    public String borrarAnimal(@ModelAttribute("animal") Animal animal){
        as.deleteAnimal(animal.getId()); //Borra animal
        return "redirect:/animals";
    }
}

/*
Clase	            Responsabilidad
-------------------------------------------------------------------------------------
Animal	            Representa un animal, con sus atributos: nombre, especie, edad…
AnimalService	    Gestiona las operaciones de los animales.
AnimalController	Gestiona las peticiones web relacionadas con animales.
MainController	    Normalmente gestiona páginas generales, como la página de inicio.
*/