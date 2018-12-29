package com.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Ingredient;
import com.app.entity.Shampoo;

@Repository
public class ShampooDAOImpl implements ShampooDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private IngredientDAO ingredientDAO;
	@Transactional
	public List<Shampoo> getShampoos() {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create query
		Query<Shampoo> theQuery = currentSession.createQuery("from Shampoo", Shampoo.class);
		//execute query and get result list
		List<Shampoo> shampoos = theQuery.getResultList();
		//return list of shampoo
		return shampoos;
	}
	
	@Transactional
	public void saveShampoo(Shampoo theShampoo) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		ListIterator<Ingredient> listIterator = theShampoo.getIngredients().listIterator();
		List<Ingredient> ingrs = new ArrayList<Ingredient>();
		while(listIterator.hasNext()) {
			//System.out.println(listIterator.next().getName());
			Ingredient one = ingredientDAO.findByName(listIterator.next().getName());
			if( one != null) {
				ingrs.add(one);
			}
			System.out.println(ingrs);
		}
		theShampoo.setIngredients(ingrs);
		
		currentSession.save(theShampoo);
		
	}

}
