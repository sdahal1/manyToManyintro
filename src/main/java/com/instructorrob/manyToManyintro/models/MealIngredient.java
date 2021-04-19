package com.instructorrob.manyToManyintro.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="meals_ingredients")
public class MealIngredient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //manyToOne with the ingredient table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;
    
    
    
    //manyToOne with the meal table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="meal_id")
    private Meal meal;
    
    
    public MealIngredient() {
    	
    }
    //constructor overloading
    public MealIngredient(Meal meal, Ingredient ingredient ) {
    	this.meal = meal;
    	this.ingredient = ingredient;
    }
    
    
    
    
   
    
    
    
    
    public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public Date getCreatedAt() {
		return createdAt;
	}







	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}







	public Date getUpdatedAt() {
		return updatedAt;
	}







	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}







	public Ingredient getIngredient() {
		return ingredient;
	}







	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}







	public Meal getMeal() {
		return meal;
	}







	public void setMeal(Meal meal) {
		this.meal = meal;
	}







	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
