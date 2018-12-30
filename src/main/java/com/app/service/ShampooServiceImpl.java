package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ShampooDAO;
import com.app.entity.Shampoo;

@Service
public class ShampooServiceImpl implements ShampooService {
	
	@Autowired
	private ShampooDAO shampooDAO;
	
	@Override
	@Transactional
	public List<Shampoo> getShampoos() {
		return shampooDAO.getShampoos();
	}

	@Override
	@Transactional
	public void saveShampoo(Shampoo theShampoo) {
		shampooDAO.saveShampoo(theShampoo);
		
	}

}
