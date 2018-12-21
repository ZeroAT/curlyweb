package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.CompanyDAO;

@Controller
@RequestMapping("company")
public class CompanyController {

	@Autowired
	private CompanyDAO companyDAO;
	
	
	
	
}
