package com.product.bean;

import java.util.List;

public class Response {

	List<Product> products;
	
	List<FinalProduct> finalProductList;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<FinalProduct> getFinalProductList() {
		return finalProductList;
	}

	public void setFinalProductList(List<FinalProduct> finalProductList) {
		this.finalProductList = finalProductList;
	}
	
	
}
