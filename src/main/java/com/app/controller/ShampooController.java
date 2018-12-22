package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		theModel.addAttribute("shampoo", theShampoo);
		
		List<Company> theCompanies = companyDAO.getCompanies();
		theModel.addAttribute("companies", theCompanies);
		
		List<Ingredient> theIngredients = ingredientDAO.getIngredients();
		//theModel.addAttribute("ingredients", theIngredients);
		
	    ModelAndView modelAndView=new ModelAndView();
	    modelMap.addAttribute("ingredients", theIngredients);
	    modelAndView.addAllObjects(modelMap);
	    modelAndView.setViewName("s");
		
		return "shampoo-form";
	}
}
