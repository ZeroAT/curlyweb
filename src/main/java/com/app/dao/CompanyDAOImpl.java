package com.app.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Company> getCompanies() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Company> theQuery = currentSession.createQuery("from Company", Company.class);
		List<Company> companies = theQuery.getResultList();

		return companies;
	}

}
