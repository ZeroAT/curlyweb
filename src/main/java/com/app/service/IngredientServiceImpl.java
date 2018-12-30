package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IngredientDAO;
import com.app.entity.Ingredient;

@Service
public class IngredientServiceImpl implements IngredientService {
	
	@Autowired
	private IngredientDAO ingredientDAO;
	
	@Override
	@Transactional
	public List<Ingredient> getIngredients() {
		return ingredientDAO.getIngredients();
	}

	@Override
	@Transactional
	public Ingredient findByName(String name) {
		return ingredientDAO.findByName(name);
	}

}
