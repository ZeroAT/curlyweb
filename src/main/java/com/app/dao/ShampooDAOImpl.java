package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Shampoo;

@Repository
public class ShampooDAOImpl implements ShampooDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
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

}
