package com.app.service;

import java.util.List;

import com.app.entity.Shampoo;

public interface ShampooService {
	
	public List<Shampoo> getShampoos();
	
	public void saveShampoo(Shampoo theShampoo);

}
