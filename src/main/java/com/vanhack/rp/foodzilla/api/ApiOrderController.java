package com.vanhack.rp.foodzilla.api;

import static java.lang.String.format;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.jr.ob.JSONObjectException;
import com.vanhack.rp.foodzilla.api.to.OrderTO;
import com.vanhack.rp.foodzilla.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@RestController
//@RequestMapping("/api/order")
//@Api(description="Order Service")
public class ApiOrderController extends ApiAbstractCloudController {

//	private Logger log = Logger.getLogger(ApiOrderController.class);
//
//	@Autowired
//	private OrderService orderService;
//
//	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
//	@ApiOperation("List all Orders")
//	@ApiImplicitParams({
//	    @ApiImplicitParam(name = "page", dataType = "int", paramType = "query", required=false,
//	            value = "Results page you want to retrieve (0..N)"),
//	    @ApiImplicitParam(name = "size", dataType = "int", paramType = "query", required=false,
//	            value = "Number of records per page.")
//	})
//	SimplePage<OrderTO> list(
//			@RequestParam(value="t", required=false) @ApiParam("Authentication token") String authToken,
////			Pageable pageable,
//			HttpServletResponse response) throws JSONObjectException, JsonProcessingException, IOException {
//		log.debug(format("order.getAll()"));
//
////		this.validateAuthenticationTokenParam(authToken);
//		log.debug("[list] running...");
//
////		Page<OrderTO> page = orderService.getAll(pageable);
//		
//		response.setStatus(HttpURLConnection.HTTP_OK);
////		return SimplePage.from(page);
//		ArrayList<OrderTO> list = new ArrayList<OrderTO>();
//		return new SimplePage<>(list);
//	}

}
