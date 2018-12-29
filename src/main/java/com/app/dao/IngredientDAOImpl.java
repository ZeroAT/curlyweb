package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Ingredient;

@Repository
public class IngredientDAOImpl implements IngredientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Ingredient> getIngredients() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingredient> theQuery = currentSession.createQuery("from Ingredient", Ingredient.class);
		List<Ingredient> ingredients = theQuery.getResultList();
		return ingredients;
	}

	@Override
	@Transactional
	public Ingredient findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Ingredient theIngredient = currentSession.get(Ingredient.class, Integer.parseInt(name));
		return theIngredient;
	}
	
	

}
