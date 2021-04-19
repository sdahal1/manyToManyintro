package com.instructorrob.manyToManyintro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.instructorrob.manyToManyintro.models.Ingredient;
import com.instructorrob.manyToManyintro.models.Meal;
import com.instructorrob.manyToManyintro.models.MealIngredient;
import com.instructorrob.manyToManyintro.repositories.IngredientRepository;
import com.instructorrob.manyToManyintro.repositories.MealIngredientRepository;
import com.instructorrob.manyToManyintro.repositories.MealRepository;

@Service
public class AppService {
	
	private final MealRepository mealRepo;
	private final IngredientRepository ingRepo;
	private final MealIngredientRepository mealIngRepo;
	
	
	public AppService(MealRepository mealRepo, IngredientRepository ingRepo, MealIngredientRepository mealIngRepo) {
		this.mealRepo = mealRepo;
		this.ingRepo = ingRepo;
		this.mealIngRepo = mealIngRepo;
	}
	
	
	public Meal createAMeal(Meal meal) {
		return this.mealRepo.save(meal);
	}
	
	public List<Meal> getAllMeals(){
		return (List<Meal>)this.mealRepo.findAll();
	}
	
	public Meal getMeal(Long id) {
		return this.mealRepo.findById(id).orElse(null);
	}
	
	public List<Ingredient> getAllIngredients(){
		return (List<Ingredient>)this.ingRepo.findAll();
	}
	
	public Ingredient getOneIngredient(Long id) {
		return this.ingRepo.findById(id).orElse(null);
	}
	
	public MealIngredient createAssociation(MealIngredient mi) {
		return this.mealIngRepo.save(mi);
	}
	
	//find all ingredients that don't have a relationship with a specific meal in the DB
	public List<Ingredient> FindLeftoverIngredients(Meal meal){
		return this.ingRepo.findByMealsNotContains(meal);
	}

	
	
	
	

}
