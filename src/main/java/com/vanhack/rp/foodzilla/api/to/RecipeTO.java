package com.vanhack.rp.foodzilla.api.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
{
    "id": 641803,
    "title": "Easy & Delish! ~ Apple Crumble",
    "image": "https://spoonacular.com/recipeImages/Easy---Delish--Apple-Crumble-641803.jpg",
    "usedIngredientCount": 3,
    "missedIngredientCount": 4,
    "likes": 1
}
 */
@JsonInclude(Include.NON_NULL)
public class RecipeTO {
	public long id;
	public String title;
	public String image;
	public int usedIngredientCount;
	public int missedIngredientCount;
	public int likes;
}
