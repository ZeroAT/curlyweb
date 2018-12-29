package com.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.CompanyDAO;
import com.app.dao.IngredientDAO;
import com.app.dao.ShampooDAO;
import com.app.entity.Company;
import com.app.entity.Ingredient;
import com.app.entity.Shampoo;

@Controller
@RequestMapping("/shampoo")
public class ShampooController {
	
	//inject DAO into controller
	@Autowired
	private ShampooDAO shampooDAO;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private IngredientDAO ingredientDAO;
	@Autowired
	private ConversionService cs;
	private Ingredient one;
	
	@RequestMapping("/list")
	public String listShampoos(Model theModel) {
		
		//get shampoo from DAO
		List<Shampoo> theShampoos = shampooDAO.getShampoos();
		
		//add shampoo to model
		theModel.addAttribute("shampoos", theShampoos);
		return "list-shampoos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, ModelMap modelMap) {
		//create model attribute to bind form data
		
		Shampoo theShampoo = new Shampoo();
		modelMap.addAttribute("shampoo", theShampoo);

		
		List<Ingredient> theIngredients = ingredientDAO.getIngredients();

		modelMap.addAttribute("ingredient", theIngredients);

		
		return "shampoo-form";
	}
	
	@PostMapping("/saveShampoo")
	public String saveShampoo(@ModelAttribute("shampoo") Shampoo theShampoo) {
		
		System.out.println(theShampoo.getIngredients());
		System.out.println(theShampoo.toString());
		
		

		//ingredientDAO.findByName(theShampoo.getIngredients())
		shampooDAO.saveShampoo(theShampoo);
		return "redirect:/shampoo/list";
		
	}
}
