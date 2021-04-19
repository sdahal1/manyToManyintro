package com.instructorrob.manyToManyintro.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.instructorrob.manyToManyintro.models.Ingredient;
import com.instructorrob.manyToManyintro.models.Meal;
import com.instructorrob.manyToManyintro.models.MealIngredient;
import com.instructorrob.manyToManyintro.services.AppService;

@Controller
public class HomeController {
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService=appService;
	}

	@RequestMapping("/")
	public String home(@ModelAttribute("meal") Meal meal, Model model) {
		model.addAttribute("allMeals", this.appService.getAllMeals() );
		
		return "index.jsp";
	}
	
	@PostMapping("/meals/create")
	public String createMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		//call the service to create a new meal
		this.appService.createAMeal(meal);
		
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/meals/{id}")
	public String showMealPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("mealToShow", this.appService.getMeal(id));
		model.addAttribute("allIngs", this.appService.FindLeftoverIngredients(this.appService.getMeal(id)));
		
		return "mealinfo.jsp";
	}
	
	@PostMapping("/addIngredientTomeal")
	public String addToMeal(@RequestParam(value="hiddenMealId") Long mealId, @RequestParam(value="selectedIng") Long ingId) {
		
		//get a meal with selected id
		Meal mealtoGet = this.appService.getMeal(mealId);
		

		//get an ingredient with selected id
		Ingredient ing = this.appService.getOneIngredient(ingId);
		
		MealIngredient association = new MealIngredient(mealtoGet, ing);
		
		//if the meal's ingredients doesn't already contain this ingredient, thenn add this ingredient to the meal's list of ingredients
		if(!mealtoGet.getIngredients().contains(ing)) {
			//tell the service to create a new entry in the third table
			this.appService.createAssociation(association);
			
		}
		
		
		return String.format("redirect:/meals/%d", mealId);
	}
	
	
}
