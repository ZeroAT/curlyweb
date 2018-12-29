package com.app.dao;

import java.util.List;

import com.app.entity.Ingredient;

public interface IngredientDAO {
	public List<Ingredient> getIngredients();
	public Ingredient findByName(String name);
}
