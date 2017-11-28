package com.vanhack.rp.foodzilla.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeTO {
	
	public String id;
	public String title;
	public String image;
	public String imageType;
	public Integer usedIngredientCount;
	public Integer missedIngredientCount;
	public Integer likes;
	public Integer readyInMinutes;
	public String instructions;
}
