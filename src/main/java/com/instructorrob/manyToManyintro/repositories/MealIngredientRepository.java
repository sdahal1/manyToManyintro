package com.instructorrob.manyToManyintro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.instructorrob.manyToManyintro.models.MealIngredient;



public interface MealIngredientRepository extends CrudRepository<MealIngredient, Long >{

}
