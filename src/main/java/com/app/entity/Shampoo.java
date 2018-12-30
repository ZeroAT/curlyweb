package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shampoo")
public class Shampoo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shampoo_id")
	private int id;
	
	@Column(name="shampoo_name")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shampoo_company")
	private Company company;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="shampoo_ingredients",
			joinColumns=@JoinColumn(name="fk_shampoo"),
			inverseJoinColumns=@JoinColumn(name="fk_ingredient")
			)
	private List<Ingredient> ingredients;
	
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


	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}



	@Override
	public String toString() {
		return "Shampoo [id=" + id + ", name=" + name + ", company=" + company + "]";
	}






}
