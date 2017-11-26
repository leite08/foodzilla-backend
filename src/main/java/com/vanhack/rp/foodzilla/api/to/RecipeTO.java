package com.vanhack.rp.foodzilla.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
{
  "image": "https:\/\/spoonacular.com\/recipeImages\/Pickled-Cucumbers-540958.jpg",
  "missedIngredientCount": 2,
  "id": 540958,
  "title": "Pickled Cucumbers",
  "imageType": "jpg",
  "usedIngredientCount": 1,
  "likes": 10
}
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeTO {
	public long id;
	public String title;
	public String image;
	public int usedIngredientCount;
	public int missedIngredientCount;
	public int likes;
}
