package com.product.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.bean.FinalProduct;
import com.product.client.ProductClient;
import com.product.util.ProductListUtil;

/**
 * @author Anuj Kumar
 * 
 *         This class is used to call the rest client to get product details.
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductClient productClientImpl;

	/**
	 * This method has implementation of the getProductList method of
	 * ProductService to prepare the product list
	 * 
	 * @param labelType
	 * @return List<FinalProduct>
	 */
	@Override
	public List<FinalProduct> getProductList(String labelType) {

		List<FinalProduct> products = new ArrayList<FinalProduct>();
		try {
			String response = productClientImpl.getProduct();
			byte[] jsonData = response.getBytes("utf-8");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(jsonData);
			JsonNode productsNode = rootNode.path("products");
			

			Iterator<JsonNode> prdItr = productsNode.elements();
			System.out.println("before forEachRemaining loop start: "+System.currentTimeMillis());
			prdItr.forEachRemaining(node->{
				prdItr.next();
				float priceRed = 0.0f;
				FinalProduct finalProduct = new FinalProduct();
				finalProduct.setProductId(node.get("productId").asText());
				finalProduct.setTitle(node.get("title").asText());

				JsonNode priceNode = node.get("price");
				if (null != priceNode) {

					// To get the price reduction
					priceRed = ProductListUtil.getPriceReduction(priceNode);

					if (priceRed > 0) {
						// To set the price label
						finalProduct.setPriceLabel(ProductListUtil.getPriceLabel(priceNode, labelType));

						// To set the now price
						finalProduct.setNowPrice(ProductListUtil.getAbsolutePrice(
								ProductListUtil.getNowPrice(priceNode), priceNode.get("currency").asText()));
					}
				}

				if (priceRed > 0) {
					JsonNode colorNode = node.path("colorSwatches");
					if (null != colorNode) {

						// To set the color swatches
						finalProduct.setColorSwatches(ProductListUtil.getColorSwatchesList(colorNode));
					}
					products.add(finalProduct);
				}				
				
				// To sort the final products list
				ProductListUtil.sortProductList(products);
				
			});
			
		
//			while (prdItr.hasNext()) {
//				JsonNode node = prdItr.next();
//				FinalProduct finalProduct = new FinalProduct();
//				finalProduct.setProductId(node.get("productId").asText());
//				finalProduct.setTitle(node.get("title").asText());
//
//				JsonNode priceNode = node.get("price");
//				if (null != priceNode) {
//
//					// To get the price reduction
//					priceRed = ProductListUtil.getPriceReduction(priceNode);
//
//					if (priceRed > 0) {
//						// To set the price label
//						finalProduct.setPriceLabel(ProductListUtil.getPriceLabel(priceNode, labelType));
//
//						// To set the now price
//						finalProduct.setNowPrice(ProductListUtil.getAbsolutePrice(
//								ProductListUtil.getNowPrice(priceNode), priceNode.get("currency").asText()));
//					}
//				}
//
//				if (priceRed > 0) {
//					JsonNode colorNode = node.path("colorSwatches");
//					if (null != colorNode) {
//
//						// To set the color swatches
//						finalProduct.setColorSwatches(ProductListUtil.getColorSwatchesList(colorNode));
//					}
//					products.add(finalProduct);
//				}				
//				
//				// To sort the final products list
//				ProductListUtil.sortProductList(products);
//			}
			System.out.println("after forEachRemaining loop end: "+System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
