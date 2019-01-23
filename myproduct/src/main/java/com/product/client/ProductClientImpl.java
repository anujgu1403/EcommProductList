package com.product.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anuj Kumar
 * 
 * This class is having REST Client implementation to communicates with integration factory
 *
 */
@Component
public class ProductClientImpl implements ProductClient{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${endpoint.uri}")
	private String uri;
	
	@Value("${endpoint.path}")
	private String path;

	
	/**
	 * This method is used to call product list rest api 
	 * 
	 * @return String
	 */
	@Override
	public String getProduct() {		
		String result =null;
		try {						
				result = restTemplate.getForObject(uri.concat(path)+"?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma", String.class);	
			
		}catch(HttpClientErrorException e) {
			e.printStackTrace();
		}
		return result;
	}

}
