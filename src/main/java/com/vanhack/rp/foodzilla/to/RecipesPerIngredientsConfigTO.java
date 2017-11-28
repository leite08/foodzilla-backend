package com.vanhack.rp.foodzilla.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RecipesPerIngredientsConfigTO {

	public String username;
	public List<String> ingredients;
	public Integer numberOfResults;
	public Boolean minimizeMissingIngredients;
}