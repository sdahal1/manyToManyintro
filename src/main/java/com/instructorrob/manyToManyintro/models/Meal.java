package com.instructorrob.manyToManyintro.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="meals")
public class Meal {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message="Hey! meal name cant be blank!")
	@Size(min=2, max=100, message= "Name gota be normal tho, stop playin'")
	private String name;
	
	private Integer num_calories;

	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meals_ingredients", //stays the same in both Ingredient and Meal models
            joinColumns = @JoinColumn(name = "meal_id"), //name a field to store an id from THIS class (Meal)
            inverseJoinColumns = @JoinColumn(name = "ingredient_id") //name a field to store an id from OTHER class (Ingredient)
        )
    private List<Ingredient> ingredients;
    
    
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum_calories() {
		return num_calories;
	}
	public void setNum_calories(Integer num_calories) {
		this.num_calories = num_calories;
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
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

}
