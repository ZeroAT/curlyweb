package com.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToMany
	@JoinTable(
			name="shampoo_ingredients",
			joinColumns=@JoinColumn(name="fk_ingredient"),
			inverseJoinColumns=@JoinColumn(name="fk_shampoo")
			)
	private List<Ingredient> ingredients;
	
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}
	
}
