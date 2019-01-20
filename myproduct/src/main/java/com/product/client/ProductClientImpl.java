package com.product.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.product.bean.Response;

@Service
public class ProductClientImpl implements ProductClient{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${endpoint.uri}")
	private String uri;
	
	@Value("${endpoint.path}")
	private String path;

	@Override
	public Response getProduct() {		
		ResponseEntity<Response> response = null;
		try {
			response = restTemplate.getForEntity(uri.concat(path)+"?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma", Response.class);
		}catch(HttpClientErrorException e) {
			e.printStackTrace();
		}
		return response.getBody();
	}

}
