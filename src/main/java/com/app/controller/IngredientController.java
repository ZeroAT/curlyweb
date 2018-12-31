package com.app.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	

	
	@RequestMapping("/list")
	public String listIngredients(Model theModel) {
		return null;
		
	}
	

}
