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
import com.vanhack.rp.foodzilla.service.RecipeService;
import com.vanhack.rp.foodzilla.to.RecipeExtendedTO;
import com.vanhack.rp.foodzilla.to.RecipeTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/recipes")
@Api(description="Recipes Service")
public class RecipesApiController extends AbstractApiController {

	// TODO: move most logging commands to trace
	private Logger log = Logger.getLogger(RecipesApiController.class);
	
	@Autowired
	private RecipeService service;

	@RequestMapping(path="/", method=RequestMethod.GET, produces="application/json")
	@ApiOperation("List recipes by ingredients")
	List<RecipeTO> searchByIngredients(
//			@RequestParam(required=true) @ApiParam("Authentication token") String authToken,
			@RequestParam(required=false) @ApiParam("Logged in username/login (future use)") String username,
			@RequestParam(required=true) @ApiParam("List of ingredients to match recipes with.") List<String> ingredients,
			@RequestParam(required=false) @ApiParam("Should the service focus o minimize missing "
					+ "ingredients? Otherwise will focus on "
					+ "maximize the user's ingredients.") boolean minimizeMissingIngredients,
			@RequestParam(required=false) @ApiParam("Maximum number of recipes to return (up to 50)") Integer numberOfResults,
			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
		log.debug(String.format("[searchByIngredients] running with (username:%s, ingredients:%s, minimizeMissingIngredients:%b, numberOfResults:%d)",
				username, (ingredients==null?null:ingredients.size()), minimizeMissingIngredients, numberOfResults));
		
//		validateAuthenticationToken(authToken);
		
		int maxAmountRecipes = numberOfResults == null ? -1 : numberOfResults;
		
		List<RecipeTO> recipes = service.getRecipesByIngredients(ingredients, maxAmountRecipes, minimizeMissingIngredients);
		
		log.debug(String.format("[searchByIngredients] returning with %s recipes", (recipes != null ? recipes.size() : null)));
		return recipes;
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces="application/json")
	@ApiOperation("Get information on recipe")
	RecipeExtendedTO getRecipe(
//			@RequestParam(required=true) @ApiParam("Authentication token") String authToken,
			@RequestParam(required=false) @ApiParam("Logged in username/login") String username,
			@PathVariable("id") @ApiParam("Identification of the recipe") String id,
			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
		log.debug("[getRecipe] running with id:" + id);

//		validateAuthenticationToken(authToken);

		RecipeExtendedTO recipe = service.getRecipe(id);;
		
		log.debug(String.format("[getRecipe] returning with recipe: %s", recipe));
		return recipe;
	}


}
