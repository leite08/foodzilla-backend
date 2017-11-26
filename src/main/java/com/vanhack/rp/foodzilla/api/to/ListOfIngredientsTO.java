package com.vanhack.rp.foodzilla.api.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ListOfIngredientsTO {
	public String username;
	public List<String> ingredients;
	public Boolean minimizeMissingIngredients;
	public Integer numberOfResults;
}
