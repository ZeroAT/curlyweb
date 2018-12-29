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
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private int id;
	
	@Column(name="ingredient_name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="shampoo_ingredients",
			joinColumns=@JoinColumn(name="fk_ingredient"),
			inverseJoinColumns=@JoinColumn(name="fk_shampoo")
			)
	private List<Shampoo> shampoos;
	
	public Ingredient() {
		
	}


	public Ingredient(String name) {
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


	public List<Shampoo> getShampoos() {
		return shampoos;
	}

	public void setShampoos(List<Shampoo> shampoos) {
		this.shampoos = shampoos;
	}


	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", shampoos=" + shampoos + "]";
	}


}
