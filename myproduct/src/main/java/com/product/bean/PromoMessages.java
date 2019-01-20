package com.product.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * @author 
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PromoMessages {

	private String priceMatched;
	
	private String offer;
	
	private String customPromotionalMessage;
	
	private String bundleHeadline;
 
	private CustomSpecialOffer customSpecialOffer;

	public String getPriceMatched() {
		return priceMatched;
	}

	public void setPriceMatched(String priceMatched) {
		this.priceMatched = priceMatched;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getCustomPromotionalMessage() {
		return customPromotionalMessage;
	}

	public void setCustomPromotionalMessage(String customPromotionalMessage) {
		this.customPromotionalMessage = customPromotionalMessage;
	}

	public String getBundleHeadline() {
		return bundleHeadline;
	}

	public void setBundleHeadline(String bundleHeadline) {
		this.bundleHeadline = bundleHeadline;
	}

	public CustomSpecialOffer getCustomSpecialOffer() {
		return customSpecialOffer;
	}

	public void setCustomSpecialOffer(CustomSpecialOffer customSpecialOffer) {
		this.customSpecialOffer = customSpecialOffer;
	}

}
