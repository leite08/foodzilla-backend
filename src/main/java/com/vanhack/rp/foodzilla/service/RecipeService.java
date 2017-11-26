package com.vanhack.rp.foodzilla.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vanhack.rp.foodzilla.api.to.ListOfIngredientsTO;
import com.vanhack.rp.foodzilla.api.to.RecipeTO;

@Service
public class RecipeService {
	
	private Logger log = Logger.getLogger(RecipeService.class);
	
	// Do not get from the properties, it's a authentication key, cannot be on the repository
	// @Value("${integration.api.key}")
	private String apiKey = System.getenv("foodzilla.apiKey");

	public List<RecipeTO> getRecipesFor(ListOfIngredientsTO list) {
		if (list == null) {
			return null;
		}
		// TODO: improve validation
		List<RecipeTO> recipes = new ArrayList<>();
		
		int number = (list.numberOfResults == null || list.numberOfResults < 0) ?
				1 : (list.numberOfResults > 50 ? 50 : list.numberOfResults);

		log.debug("running with apiKey: "+apiKey);
		try {
			// TODO: move to a specific service
			// TODO: use Asynchronous Requests (http://unirest.io/java)
			HttpResponse<JsonNode> apiResponse = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients")
					.header("X-Mashape-Key", apiKey)
					.header("Accept", "application/json")
					.queryString("ingredients", list.ingredients)
					.queryString("ranking", (list.minimizeMissingIngredients?2:1))
					.queryString("number", number)
					.asJson();
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
			
		} catch (UnirestException | IOException e) {
			log.error("Exception loading list of recipes", e);
		}

		log.debug(String.format("returning with %d recipes", recipes.size()));
		return recipes;
	}

}
