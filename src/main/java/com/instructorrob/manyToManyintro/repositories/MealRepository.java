package com.instructorrob.manyToManyintro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.instructorrob.manyToManyintro.models.Meal;

public interface MealRepository extends CrudRepository<Meal, Long >{

}
