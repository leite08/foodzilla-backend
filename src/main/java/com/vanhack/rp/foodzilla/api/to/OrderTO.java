package com.vanhack.rp.foodzilla.api.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderTO {
	public String id;
	public String name;
	public String description;
}
