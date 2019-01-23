package com.product.service;

import java.util.List;
import com.product.bean.FinalProduct;


/**
 * @author Anuj Kumar
 *
 *This class is used to call the rest client to get product details
 *
 */
public interface ProductService {

	/**
	 * This method is used to prepare the final product list
	 * 
	 * @param labelType
	 * @return List<FinalProduct>
	 */
	public List<FinalProduct> getProductList(String labelType);

}
