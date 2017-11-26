package com.vanhack.rp.foodzilla.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.jr.ob.JSONObjectException;
import com.vanhack.rp.foodzilla.api.to.RecipeTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/recipes")
@Api(description="Recipes Service")
public class ApiRecipesController extends ApiAbstractCloudController {

	private Logger log = Logger.getLogger(ApiRecipesController.class);

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ApiOperation("List recipes by ingredients")
	List<RecipeTO> searchByIngredients(
			@RequestParam(required=false) @ApiParam("Logged in username/login") String username,
			@RequestParam(required=true) @ApiParam("List of ingredients to match recipes with.") List<String> ingredients,
			@RequestParam(required=false) @ApiParam("Should the service focus o minimize missing "
					+ "ingredients? Otherwise will focus on "
					+ "maximize the user's ingredients.") boolean minimizeMissingIngredients,
			@RequestParam(required=false) @ApiParam("Maximum number of recipes to return (up to 50") Integer numberOfResults,
			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
		log.debug("[list] running...");
		
		numberOfResults = (numberOfResults == null || numberOfResults < 0) ? 1 : (numberOfResults > 50 ? 50 : numberOfResults);

		String[] titles = new String[]{
				"Lasagna", 
				"Pizza", 
				"Summer pasta", 
				"Italian Chop Salad", 
				"Greek Tortellini", 
				"Salmon Pasta Salad", 
				"Healthy spinach"};
		String[] images = new String[]{
				"https://s2.glbimg.com/rBnKcChnckKHD_oJyLds_EjZDDk=/540x304/top/smart/http://s.glbimg.com/po/rc/media/2016/01/28/16_42_41_282_arroz_de_forno_com_mandioquinha_palha_hero.jpg", "Pizza", "Summer pasta", "Italian Chop Salad", 
				"http://www.muitochique.com/wp-content/uploads/2014/04/receita-bombom-trufa-de-banana-446x275.jpg",
				"https://abrilclaudia.files.wordpress.com/2017/07/receita-arroz-de-forno-02.jpg?quality=85&strip=info&strip=info",
				"https://abrilclaudia.files.wordpress.com/2016/10/receita-macarrao-molho-requeijao-maionese.jpg?quality=85&strip=info&w=620",
				"https://pbs.twimg.com/media/CrCQ8EyWYAAZg8v.jpg",
				"https://3.bp.blogspot.com/-TxPbwLEFXZU/VxvN56DlovI/AAAAAAAAADY/W_47TbLfeEQd0RgXuXvdCLAruuGkeJm7ACLcB/s1600/Quibe%2Bde%2Bforno%2Blight%2Bcom%2Bcottage.jpg"
				};
		
		Random random = new Random();
		List<RecipeTO> list = new ArrayList<>();
		for (int i=0; i<numberOfResults; i++) {
			RecipeTO recipe = new RecipeTO();
			recipe.id = random.nextLong();
			if (recipe.id < 0) recipe.id *= -1; 
			recipe.title = titles[random.nextInt(titles.length)];
			recipe.image = images[random.nextInt(images.length)];
			recipe.missedIngredientCount = random.nextInt(ingredients.size());
			recipe.usedIngredientCount = ingredients.size()-recipe.missedIngredientCount;
			recipe.likes = random.nextInt(200);
			list.add(recipe);
		}
		return list;
	}

}
