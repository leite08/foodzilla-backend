package com.vanhack.rp.foodzilla.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.jr.ob.JSONObjectException;
import com.vanhack.rp.foodzilla.api.to.ListOfIngredientsTO;
import com.vanhack.rp.foodzilla.api.to.RecipeExtendedTO;
import com.vanhack.rp.foodzilla.api.to.RecipeTO;
import com.vanhack.rp.foodzilla.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/recipes")
@Api(description="Recipes Service")
public class ApiRecipesController extends ApiAbstractCloudController {

	private Logger log = Logger.getLogger(ApiRecipesController.class);
	
	@Autowired
	private RecipeService service;

	@RequestMapping(path="/", method=RequestMethod.GET, produces="application/json")
	@ApiOperation("List recipes by ingredients")
	List<RecipeTO> searchByIngredients(
			@RequestParam(required=false) @ApiParam("Logged in username/login (future use)") String username,
			@RequestParam(required=true) @ApiParam("List of ingredients to match recipes with.") List<String> ingredients,
			@RequestParam(required=false) @ApiParam("Should the service focus o minimize missing "
					+ "ingredients? Otherwise will focus on "
					+ "maximize the user's ingredients.") boolean minimizeMissingIngredients,
			@RequestParam(required=false) @ApiParam("Maximum number of recipes to return (up to 50)") Integer numberOfResults,
			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
		log.debug("[searchByIngredients] running...");
		
		ListOfIngredientsTO listOfIngredients = new ListOfIngredientsTO();
		listOfIngredients.ingredients = ingredients;
		listOfIngredients.minimizeMissingIngredients = minimizeMissingIngredients;
		listOfIngredients.numberOfResults = numberOfResults;
		listOfIngredients.username = username;
		
		List<RecipeTO> recipes = service.getRecipesFor(listOfIngredients);
		
		log.debug(String.format("[searchByIngredients] returning with %s recipes", (recipes!=null?recipes.size():null)));
		return recipes;
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces="application/json")
	@ApiOperation("Get information on recipe")
	RecipeExtendedTO getRecipe(
			@RequestParam(required=false) @ApiParam("Logged in username/login") String username,
			@PathVariable("id") @ApiParam("Identification of the recipe") String id,
			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
		log.debug("[getRecipe] running...");
		
		RecipeExtendedTO recipe = service.getRecipe(id);
		
		log.debug(String.format("[getRecipe] returning with recipe: %s", recipe));
		return recipe;
	}


}
