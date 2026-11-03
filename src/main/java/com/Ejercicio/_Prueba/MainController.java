package com.Ejercicio._Prueba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/")
	public String Main(Model model) { //el Model debe ser el de org.springframework.ui, si no peta
		return "index";
	}
}