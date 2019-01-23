package com.product.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.bean.FinalColorSwatch;
import com.product.bean.FinalProduct;
import com.product.bean.Response;
import com.product.client.ProductClient;
import com.product.util.ProductListUtil;

/**
 * @author Anuj Kumar
 * 
 * This class is used to call the rest client to get product details.
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductClient productClientImpl;
	
	/**
	 * This method has implementation of the getProductList method of ProductService to prepare the product list
	 * 
	 * @param labelType
	 * @return List<FinalProduct>
	 */
	@Override
	public List<FinalProduct> getProductList(String labelType) {
		Response response = productClientImpl.getProduct();

		List<FinalProduct> products = new ArrayList<FinalProduct>();
		response.getProducts().parallelStream().forEach(product -> {

			FinalProduct finalProduct = new FinalProduct();
			finalProduct.setProductId(product.getProductId());
			finalProduct.setTitle(product.getTitle());
			
			List<FinalColorSwatch> finalColorSwatches = new ArrayList<FinalColorSwatch>();
			product.getColorSwatches().parallelStream().forEach(colorSwatch -> {
				FinalColorSwatch finalColorSwatch = new FinalColorSwatch();
				finalColorSwatch.setColor(colorSwatch.getColor());
				finalColorSwatch.setSkuId(colorSwatch.getSkuId());
				
				if (null != colorSwatch.getBasicColor()) {
					finalColorSwatch.setRgbColor(ProductListUtil.getHexaColorCode(colorSwatch.getBasicColor()));
					finalColorSwatches.add(finalColorSwatch);
				}
			});
			finalProduct.setColorSwatches(finalColorSwatches);
			 
			if (null != product.getPrice()) 
				finalProduct.setPriceLabel(ProductListUtil.getPriceLabel(product.getPrice(), labelType));
				
				if(null != product.getPrice().getNow()){					
					finalProduct.setNowPrice(ProductListUtil.getAbsolutePrice(product.getPrice().getNow(), product.getPrice().getCurrency()));
				}else {
					finalProduct.setNowPrice(ProductListUtil.getAbsolutePrice("0.0","GBP"));
				}			

			products.add(finalProduct);

		});
		return products;
	}
}
