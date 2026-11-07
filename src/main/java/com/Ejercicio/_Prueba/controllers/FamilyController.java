package com.Ejercicio._Prueba.controllers;

import com.Ejercicio._Prueba.interfaces.FamilyService;
import com.Ejercicio._Prueba.models.Animal;
import com.Ejercicio._Prueba.models.Family;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FamilyController {

    @Autowired
    private FamilyService fs;

    @GetMapping("/families")
    public String animales(Model model){
        model.addAttribute("families", fs.getFamilies());
        return "Family/families";
    }


    @GetMapping("/families/familyDetails/{id}")
    public String DetallesAnimal(@PathVariable int id, Model model) {
        Family littleFamily = fs.getFamily(id);
        String response = "redirect:/families";
        if(littleFamily != null){
            model.addAttribute("animal", littleFamily);
            response = "Family/familyDetails";
        }
        return response;
    }

    @GetMapping("/families/familyCreate")
    public String createFamily(Model model){
        model.addAttribute("family", new Family());
        return "Family/familyCreate";
    }


    @PostMapping("/families/familyCreate")
    public String createFamily(@Valid @ModelAttribute("family") Family family, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Family/familyCreate";
        } else {
            fs.addFamily(family);
            return "redirect:/families/familyDetails/" + family.getId();
        }
    }

    @GetMapping("/families/familyEdit/{id}")
    public String EditFamily(Model model, @PathVariable int id){
        model.addAttribute("family", fs.getFamily(id));
        return "Family/familyEdit";
    }

    @PostMapping("/families/familyEdit")
    public String EditFamily(@Valid @ModelAttribute("family") Family family, BindingResult bindingResult){
        String resultado = "redirect:/families";
        if(bindingResult.hasErrors()){
            resultado = "families/familyEdit";
        }else{
            fs.editFamily(family);
        }
        return resultado;
    }

    @GetMapping("/families/familyDelete/{id}")
    public String deleteFamily(Model model, @PathVariable int id){
        model.addAttribute("family", fs.getFamily(id)); //Recibe Family
        return "Family/familyDelete";
    }

    @PostMapping("/families/familyDelete")
    public String deleteFamily(@ModelAttribute("family") Family family){
        fs.deleteFamily(family.getId()); //Borra Family
        return "redirect:/families";
    }

}
