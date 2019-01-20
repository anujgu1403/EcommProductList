package com.product.service;

import java.util.List;
import com.product.bean.FinalProduct;


/**
 * @author Anuj Kumar
 *
 */
public interface ProductService {

	public List<FinalProduct> getProductList(String labelType);

}
