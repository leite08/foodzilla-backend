package com.vanhack.rp.foodzilla.api.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeExtendedTO extends RecipeTO {

	public List<IngredientTO> extendedIngredients;
}
