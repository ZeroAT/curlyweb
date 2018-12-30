package com.app.service;

import java.util.List;

import com.app.entity.Ingredient;

public interface IngredientService {

	public List<Ingredient> getIngredients();
	
	
	public Ingredient findByName(String name);
	
}
