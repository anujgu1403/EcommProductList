package com.product.util;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.product.bean.FinalColorSwatch;

/**
 * @author Anuj Kumar
 * 
 *         This util class is used to have common methods used in product
 *         service.
 *
 */
public class ProductListUtil {

	/**
	 * This method is used to form the price label according to various conditions
	 * 
	 * @param labelType
	 * @param priceNode
	 * @return String
	 */
	public static String getPriceLabel(JsonNode priceNode, String labelType) {
		String priceLabel = "";
		switch (labelType) {
		case "ShowWasNow":
			
			priceLabel = "Was " + getAbsolutePrice(priceNode.get("was").asText(), priceNode.get("currency").asText()) + " now "
					+ getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText());
			break;
		case "ShowWasThenNow":
			if (null != priceNode.get("then2").asText() && !priceNode.get("then2").asText().equalsIgnoreCase(""))
				priceLabel = "Was " + getAbsolutePrice(priceNode.get("was").asText(), priceNode.get("currency").asText()) + " then "
						+ getAbsolutePrice(priceNode.get("then2").asText(), priceNode.get("currency").asText()) + " now "
						+ getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText());
			
			else if ((null == priceNode.get("then2").asText() || priceNode.get("then2").asText().equalsIgnoreCase(""))
					&& (null != priceNode.get("then1").asText() && !priceNode.get("then1").asText().equalsIgnoreCase("")))
				priceLabel = "Was " + getAbsolutePrice(priceNode.get("was").asText(), priceNode.get("currency").asText()) + " then "
						+ getAbsolutePrice(priceNode.get("then1").asText(), priceNode.get("currency").asText()) + " now "
						+ getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText());
			else
				priceLabel = "Was " + getAbsolutePrice(priceNode.get("was").asText(), priceNode.get("currency").asText()) + " now "
						+ getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText());
			break;
		case "ShowPercDscount":
			priceLabel = "X%off-now ".concat(getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText()));
			break;
		default:
			priceLabel = "Was " + getAbsolutePrice(priceNode.get("was").asText(), priceNode.get("currency").asText()) + " now "
					+ getAbsolutePrice(getNowPrice(priceNode), priceNode.get("currency").asText());
		}
		return priceLabel;
	}

	/**
	 * This method is used to get the absolute price
	 * 
	 * @param price
	 * @param currency
	 * @return String
	 */
	public static String getAbsolutePrice(String price, String currency) {
		String poundCurrency = "";
		String priceValue = "";
		if (currency.equalsIgnoreCase("GBP"))
			poundCurrency = "\u00a3";
		else
			poundCurrency = currency;

		if (null != price && !price.isEmpty()) {
			if (Float.parseFloat(price) < 10)
				priceValue = poundCurrency + Float.parseFloat(price);
			else
				priceValue = poundCurrency + Math.round(Float.parseFloat(price));
		} else {
			priceValue = poundCurrency + "0.0";
		}
		return priceValue;
	}

	/**
	 * This method is used to get the now price
	 * 
	 * @param priceNode
	 * @param price
	 * @return String
	 */
	public static String getNowPrice(JsonNode priceNode) {
		String nowPrice = "";
		if (priceNode.get("now").isObject()) {
			JsonNode nowNode = priceNode.get("now");
			nowPrice = nowNode.get("to").asText();			
		} else {
			nowPrice = priceNode.get("now").asText();
		}
		return nowPrice;
	}

	/**
	 * This method is used to get the hexa color code for color string value
	 * 
	 * @param basicColor
	 * @return String
	 */
	public static String getHexaColorCode(String basicColor) {
		String hexaColorCode = "";
		if (null != basicColor) {
			Color color = null;
			try {
				Field field = Color.class.getField(basicColor.toLowerCase());
				color = (Color) field.get(null);
			} catch (Exception e) {
			}

			if (null != color)
				hexaColorCode = Integer.toHexString(color.getRGB());
		}
		return hexaColorCode;
	}

	/**
	 * This method is used to get the color swatches list
	 * 
	 * @param colorNode
	 * @return List<FinalColorSwatch>
	 */
	public static List<FinalColorSwatch> getColorSwatchesList(JsonNode colorNode) {

		List<FinalColorSwatch> finalColorSwatches = new ArrayList<FinalColorSwatch>();
		Iterator<JsonNode> colorItr = colorNode.elements();
		while (colorItr.hasNext()) {
			JsonNode tempNode = colorItr.next();
			FinalColorSwatch finalColorSwatch = new FinalColorSwatch();
			finalColorSwatch.setSkuId(tempNode.get("skuId").asText());
			finalColorSwatch.setColor(tempNode.get("color").asText());
			if (null != tempNode.get("basicColor").asText()) {
				finalColorSwatch.setRgbColor(ProductListUtil.getHexaColorCode(tempNode.get("basicColor").asText()));
				finalColorSwatches.add(finalColorSwatch);
			}
		}
		return finalColorSwatches;
	}
}