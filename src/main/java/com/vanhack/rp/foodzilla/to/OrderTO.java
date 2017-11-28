package com.vanhack.rp.foodzilla.to;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderTO {
	
	public String id;
	public String username;
	public Date when;
	public List<IngredientTO> ingredients;
}
