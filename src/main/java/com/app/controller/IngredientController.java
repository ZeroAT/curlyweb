package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IngredientDAO;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientDAO IngredientDAO;
	
	@RequestMapping("/list")
	public String listIngredients(Model theModel) {
		return null;
		
	}
	

}
