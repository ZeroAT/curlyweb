package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.CompanyDAO;
import com.app.dao.ShampooDAO;
import com.app.entity.Company;
import com.app.entity.Shampoo;

@Controller
@RequestMapping("/shampoo")
public class ShampooController {
	
	//inject DAO into controller
	@Autowired
	private ShampooDAO shampooDAO;
	@Autowired
	private CompanyDAO companyDAO;
	
	@RequestMapping("/list")
	public String listShampoos(Model theModel) {
		
		//get shampoo from DAO
		List<Shampoo> theShampoos = shampooDAO.getShampoos();
		
		//add shampoo to model
		theModel.addAttribute("shampoos", theShampoos);
		return "list-shampoos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		
		Shampoo theShampoo = new Shampoo();
		theModel.addAttribute("shampoo", theShampoo);
		
		List<Company> theCompanies = companyDAO.getCompanies();
		theModel.addAttribute("companies", theCompanies);
		
		return "shampoo-form";
	}
}
