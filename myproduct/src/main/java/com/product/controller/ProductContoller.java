package com.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.product.bean.FinalProduct;
import com.product.bean.Response;
import com.product.service.ProductService;

/**
 * @author Anuj Kumar
 *
 */

@RestController
public class ProductContoller {
	
	@Autowired
	ProductService productService;

	@GetMapping(produces = "application/json",path="/v1")
	public ResponseEntity<Response> getProductList(@RequestParam(required=false) String labelType){
		if(null==labelType)
			labelType="";
		List<FinalProduct> finalProductList = productService.getProductList(labelType);
		if(null != finalProductList && !finalProductList.isEmpty())
		{
			Response response = new Response();
			response.setFinalProductList(finalProductList);
			return ResponseEntity.ok(response);
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
