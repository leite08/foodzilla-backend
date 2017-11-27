package com.vanhack.rp.foodzilla.api.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ListOfIngredientsTO {
	public String username;
	public List<String> ingredients;
	public Integer numberOfResults;
	@JsonIgnore
	public Boolean minimizeMissingIngredients;
	public int getNumber() {
		int number = (numberOfResults == null || numberOfResults < 0) ?
				1 : (numberOfResults > 50 ? 50 : numberOfResults);
		return number;
	}
}
