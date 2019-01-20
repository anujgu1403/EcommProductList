package com.product.util;

import java.awt.Color;
import java.lang.reflect.Field;
import com.product.bean.Price;

/**
 * @author Anuj Kumar
 *
 */
public class ProductListUtil {

	public static String getPriceLabel(Price price, String labelType) {
		String priceLabel = "";		
		switch (labelType) {
		case "ShowWasNow":			
			priceLabel = "Was " + getAbsolutePrice(price.getWas(), price.getCurrency()) + " now " + getAbsolutePrice(price.getNow(), price.getCurrency());
			break;
		case "ShowWasThenNow":
			if(null!= price.getThen2() && !price.getThen2().equalsIgnoreCase(""))
				priceLabel = "Was " + getAbsolutePrice(price.getWas(), price.getCurrency()) + " then "+getAbsolutePrice(price.getThen2(), price.getCurrency())+" now " + getAbsolutePrice(price.getNow(), price.getCurrency());
			else if((null== price.getThen2() || price.getThen2().equalsIgnoreCase("")) && (null!= price.getThen1() && !price.getThen1().equalsIgnoreCase("")))
				priceLabel = "Was " + getAbsolutePrice(price.getWas(), price.getCurrency()) + " then "+getAbsolutePrice(price.getThen1(), price.getCurrency())+" now " + getAbsolutePrice(price.getNow(), price.getCurrency());
			else
				priceLabel = "Was " + getAbsolutePrice(price.getWas(), price.getCurrency()) +" now " + getAbsolutePrice(price.getNow(), price.getCurrency());
			break;
		case "ShowPercDscount":
			priceLabel = "X%off-now ".concat(getAbsolutePrice(price.getNow(), price.getCurrency()));
			break;
		default:
			priceLabel = "Was " + getAbsolutePrice(price.getWas(), price.getCurrency()) + " now " + getAbsolutePrice(price.getNow(), price.getCurrency());
		}
		return priceLabel;
	}
	
	public static String getAbsolutePrice(String price, String currency) {
		System.out.println("price: "+price + "currency :"+currency);
		
		String poundCurrency = "";
		String priceValue = "";
		if(currency.equalsIgnoreCase("GBP")) 
			poundCurrency = "\u00a3";
		else
			poundCurrency = currency;
		
		if(null != price && !price.isEmpty()) {
			if (Float.parseFloat(price) < 10)
				priceValue = poundCurrency+Float.parseFloat(price);
			else
				priceValue = poundCurrency+Math.round(Float.parseFloat(price));				
			}else {
				priceValue = poundCurrency+"0.0";
			}
		return priceValue;
		}
	
	public static String getHexaColorCode(String basicColor) {
		String hexaColorCode = "";
		if (null != basicColor) {
			Color color = null;
			try {
			    Field field = Color.class.getField(basicColor.toLowerCase());
			    color = (Color)field.get(null);
			} catch (Exception e) {}
			
			if (null != color)
				hexaColorCode = Integer.toHexString(color.getRGB());		
		}
		return hexaColorCode;
	}
}