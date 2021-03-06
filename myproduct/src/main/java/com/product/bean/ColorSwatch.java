package com.product.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ColorSwatch {
	
	private String color;
	
	private String basicColor;
	
	private String colorSwatchUrl;
	
	private String imageUrl;
	
	private boolean available;
	
	private String skuId;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBasicColor() {
		return basicColor;
	}

	public void setBasicColor(String basicColor) {
		this.basicColor = basicColor;
	}

	public String getColorSwatchUrl() {
		return colorSwatchUrl;
	}

	public void setColorSwatchUrl(String colorSwatchUrl) {
		this.colorSwatchUrl = colorSwatchUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

}
