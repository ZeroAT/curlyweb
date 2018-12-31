package com.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Ingredient;
import com.app.entity.Shampoo;
import com.app.service.IngredientService;
import com.app.service.ShampooService;

@Controller
@RequestMapping("/shampoo")
public class ShampooController {
	

	@Autowired
	private ShampooService shampooService;
	@Autowired
	private IngredientService ingredientService;
	
	
	@RequestMapping("/list")
	public String listShampoos(Model theModel) {
		

		List<Shampoo> theShampoos = shampooService.getShampoos();
		

		theModel.addAttribute("shampoos", theShampoos);
		return "list-shampoos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, ModelMap modelMap) {

		
		Shampoo theShampoo = new Shampoo();
		modelMap.addAttribute("shampoo", theShampoo);

		
		List<Ingredient> theIngredients = ingredientService.getIngredients();

		modelMap.addAttribute("ingredient", theIngredients);

		
		return "shampoo-form";
	}
	
	@PostMapping("/saveShampoo")
	public String saveShampoo(@ModelAttribute("shampoo") Shampoo theShampoo) {
		

		shampooService.saveShampoo(theShampoo);
		return "redirect:/shampoo/list";
		
	}
}
