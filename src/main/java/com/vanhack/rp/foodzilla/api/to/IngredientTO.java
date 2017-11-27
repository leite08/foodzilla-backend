package com.vanhack.rp.foodzilla.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientTO {
	
	public String id;
	public String image;
	public String name;
	public String amount;
	public String unit;
}
