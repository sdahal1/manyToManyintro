package com.instructorrob.manyToManyintro.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.instructorrob.manyToManyintro.models.Ingredient;
import com.instructorrob.manyToManyintro.models.Meal;

public interface IngredientRepository extends CrudRepository<Ingredient, Long > {

	
	List<Ingredient> findByMealsNotContains(Meal meal);
}
