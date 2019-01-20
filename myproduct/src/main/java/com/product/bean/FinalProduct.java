package com.product.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FinalProduct {

	private String productId;
	
	private String title;
	
	private List<FinalColorSwatch> colorSwatches;
	
	private String nowPrice;
	
	private String priceLabel;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<FinalColorSwatch> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(List<FinalColorSwatch> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}
}
