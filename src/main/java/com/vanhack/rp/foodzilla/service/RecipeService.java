package com.vanhack.rp.foodzilla.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vanhack.rp.foodzilla.exception.IntegrationException;
import com.vanhack.rp.foodzilla.to.IngredientTO;
import com.vanhack.rp.foodzilla.to.RecipeExtendedTO;
import com.vanhack.rp.foodzilla.to.RecipeTO;

@Service
public class RecipeService {

	private Logger log = Logger.getLogger(RecipeService.class);

	// Do not get from the properties, it's a authentication key, cannot be on the repository
	private String apiKey = System.getenv("foodzillaApiKey");
	@Value("${integration.api.url}")
	private String apiUrl;
	@Value("${integration.api.endpoints.recipesPerIngredients}")
	private String recipesPerIngredientsEndpoint;
	@Value("${integration.api.endpoints.recipeDetails}")
	private String recipeDetailsEndpoint;

	public List<RecipeTO> getRecipesByIngredients(List<String> ingredientsNames, int maxAmountRecipes,
			boolean minimizeMissingIngredients) throws JsonParseException, JsonMappingException, IOException {
		log.debug("[getRecipesFor] running");
		
		if (ingredientsNames == null || ingredientsNames.size() <= 0) {
			return new ArrayList<RecipeTO>();
		}

		int number = (maxAmountRecipes <= 0) ? 1
				: (maxAmountRecipes > 50 ? 50 : maxAmountRecipes);

		try {
			// TODO: use Asynchronous Requests (http://unirest.io/java)
			HttpResponse<JsonNode> apiResponse = Unirest.get(apiUrl + recipesPerIngredientsEndpoint)
					.header("X-Mashape-Key", apiKey)
					.header("Accept", "application/json")
					.queryString("ingredients", ingredientsNames)
					.queryString("ranking", (minimizeMissingIngredients ? 2 : 1))
					.queryString("number", number)
					.asJson();
			log.debug("[getRecipesFor] Got response from the server: " + apiResponse.getStatus());
			List<RecipeTO> recipes = new ArrayList<>();
			if (apiResponse != null && apiResponse.getStatus() == HttpServletResponse.SC_OK) {
				JSONArray array = apiResponse.getBody().getArray();
				for (int i = 0, size = array.length(); i < size; i++) {
					JSONObject object = array.getJSONObject(i);
					ObjectMapper mapper = new ObjectMapper();
					RecipeTO recipe = mapper.readValue(object.toString(), RecipeTO.class);
					recipes.add(recipe);
				}
			} else {
				log.debug("Failed to retrieve the list of recipes");
			}
			log.debug(String.format("returning with %d recipes", recipes.size()));
			return recipes;

		} catch (UnirestException e) {
			log.error("Exception loading list of recipes", e);
			throw new IntegrationException(e);
		} finally {
			log.debug("[getRecipesFor] leaving");
		}
	}

	public RecipeExtendedTO getRecipe(String id) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}

		log.debug("[getRecipes] running");
		try {
			// TODO: use Asynchronous Requests (http://unirest.io/java)
			HttpResponse<JsonNode> apiResponse = Unirest.get(apiUrl + recipeDetailsEndpoint)
					.header("X-Mashape-Key", apiKey).header("Accept", "application/json").asJson();
			log.debug("[getRecipes] got response from the server: " + apiResponse.getStatus());

			if (apiResponse != null && apiResponse.getStatus() == HttpServletResponse.SC_OK) {
				JSONObject object = apiResponse.getBody().getObject();
				ObjectMapper mapper = new ObjectMapper();

				RecipeExtendedTO recipe = mapper.readValue(object.toString(), RecipeExtendedTO.class);

				JSONArray jsonArray = object.getJSONArray("extendedIngredients");
				if (jsonArray != null && jsonArray.length() > 0) {
					recipe.extendedIngredients = new ArrayList<>();
				}
				for (int i = 0, size = jsonArray.length(); i < size; i++) {
					JSONObject item = jsonArray.getJSONObject(i);
					IngredientTO ingredient = mapper.readValue(item.toString(), IngredientTO.class);
					recipe.extendedIngredients.add(ingredient);
				}
				log.debug(String.format("[getRecipes] returning with recipe: ", recipe));
				return recipe;

			} else {
				log.debug("[getRecipes] Failed to retrieve the list of recipes");
			}
		} catch (UnirestException | IOException e) {
			log.error("Exception loading list of recipes", e);
		}
		log.debug("[getRecipes] Returning with no recipe");
		return null;
	}
}
