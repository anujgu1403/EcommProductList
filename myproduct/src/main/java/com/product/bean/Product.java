package com.product.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
/**
 * 
 * @author 
 *
 */
@JsonIgnoreType
public class Product {

	private String productId;
	
	private String type;
	
	private String title;
	
	private String code;
	
	private String averageRating;
	
	private int reviews;
	
	private Price price;
	
	private String image;
	
	private String displaySpecialOffer;
	
	private PromoMessages promoMessages;
	
	private String nonPromoMessage;
	
	private String defaultSkuId;
	
	private List<ColorSwatch> colorSwatches;

	private int colorSwatchSelected;
	
	private String colorWheelMessage;
	
	private boolean outOfStock;
	
	private boolean emailMeWhenAvailable;
	
	private String availabilityMessage;
	
	private String compare;
	
	private String fabric;
	
	private String swatchAvailable;
	
	private String categoryQuickViewEnabled;
	
	private String swatchCategoryType;
	
	private String brand;
	
	private int ageRestriction;
	
	private boolean inStoreOnly;
	
	private boolean madeToMeasure;
	
	private boolean bundle;
	
	private boolean productSet;
	
	private List<PromotionalFeature> promotionalFeatures;
	
	private List<Feature> features;
	
	private DynamicAttributes dynamicAttributes;
	
	private String directorate;
	
	private int releaseDateTimestamp;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDisplaySpecialOffer() {
		return displaySpecialOffer;
	}

	public void setDisplaySpecialOffer(String displaySpecialOffer) {
		this.displaySpecialOffer = displaySpecialOffer;
	}

	public PromoMessages getPromoMessages() {
		return promoMessages;
	}

	public void setPromoMessages(PromoMessages promoMessages) {
		this.promoMessages = promoMessages;
	}

	public String getNonPromoMessage() {
		return nonPromoMessage;
	}

	public void setNonPromoMessage(String nonPromoMessage) {
		this.nonPromoMessage = nonPromoMessage;
	}

	public String getDefaultSkuId() {
		return defaultSkuId;
	}

	public void setDefaultSkuId(String defaultSkuId) {
		this.defaultSkuId = defaultSkuId;
	}

	public int getColorSwatchSelected() {
		return colorSwatchSelected;
	}

	public void setColorSwatchSelected(int colorSwatchSelected) {
		this.colorSwatchSelected = colorSwatchSelected;
	}

	public String getColorWheelMessage() {
		return colorWheelMessage;
	}

	public void setColorWheelMessage(String colorWheelMessage) {
		this.colorWheelMessage = colorWheelMessage;
	}

	public boolean isOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	public boolean isEmailMeWhenAvailable() {
		return emailMeWhenAvailable;
	}

	public void setEmailMeWhenAvailable(boolean emailMeWhenAvailable) {
		this.emailMeWhenAvailable = emailMeWhenAvailable;
	}

	public String getAvailabilityMessage() {
		return availabilityMessage;
	}

	public void setAvailabilityMessage(String availabilityMessage) {
		this.availabilityMessage = availabilityMessage;
	}

	public String getCompare() {
		return compare;
	}

	public void setCompare(String compare) {
		this.compare = compare;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getSwatchAvailable() {
		return swatchAvailable;
	}

	public void setSwatchAvailable(String swatchAvailable) {
		this.swatchAvailable = swatchAvailable;
	}

	public String getCategoryQuickViewEnabled() {
		return categoryQuickViewEnabled;
	}

	public void setCategoryQuickViewEnabled(String categoryQuickViewEnabled) {
		this.categoryQuickViewEnabled = categoryQuickViewEnabled;
	}

	public String getSwatchCategoryType() {
		return swatchCategoryType;
	}

	public void setSwatchCategoryType(String swatchCategoryType) {
		this.swatchCategoryType = swatchCategoryType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public boolean isInStoreOnly() {
		return inStoreOnly;
	}

	public void setInStoreOnly(boolean inStoreOnly) {
		this.inStoreOnly = inStoreOnly;
	}

	public boolean isMadeToMeasure() {
		return madeToMeasure;
	}

	public void setMadeToMeasure(boolean madeToMeasure) {
		this.madeToMeasure = madeToMeasure;
	}

	public boolean isBundle() {
		return bundle;
	}

	public void setBundle(boolean bundle) {
		this.bundle = bundle;
	}

	public boolean isProductSet() {
		return productSet;
	}

	public void setProductSet(boolean productSet) {
		this.productSet = productSet;
	}

	public List<PromotionalFeature> getPromotionalFeatures() {
		return promotionalFeatures;
	}

	public void setPromotionalFeatures(List<PromotionalFeature> promotionalFeatures) {
		this.promotionalFeatures = promotionalFeatures;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public DynamicAttributes getDynamicAttributes() {
		return dynamicAttributes;
	}

	public void setDynamicAttributes(DynamicAttributes dynamicAttributes) {
		this.dynamicAttributes = dynamicAttributes;
	}

	public String getDirectorate() {
		return directorate;
	}

	public void setDirectorate(String directorate) {
		this.directorate = directorate;
	}

	public int getReleaseDateTimestamp() {
		return releaseDateTimestamp;
	}

	public void setReleaseDateTimestamp(int releaseDateTimestamp) {
		this.releaseDateTimestamp = releaseDateTimestamp;
	}
	public List<ColorSwatch> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(List<ColorSwatch> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}
}
