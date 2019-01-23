package com.product.client;

import com.product.bean.Response;

/**
 * This interface is used to communicate with integration factory.
 * 
 * @author Anuj Kumar
 *
 */
public interface ProductClient {
	
	/**
	 * This method is used to get products list by calling the REST endpoint of integration factory
	 * 
	 * @return Response
	 */
	public Response getProduct();

}
