package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shampoo")
public class Shampoo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="shampoo_id")
	private int id;
	
	@Column(name="shampoo_name")
	private String name;
	
	@OneToOne
	@JoinColumn(name="shampoo_company")
	private Company company;
	
	public Shampoo() {
		
	}

	public Shampoo(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Shampoo [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	
	
	//annotate class and map to db table
	
	//define fields
	
	//annotate the fields
	
	//create constructors
	
	//getters/setters
	
}
