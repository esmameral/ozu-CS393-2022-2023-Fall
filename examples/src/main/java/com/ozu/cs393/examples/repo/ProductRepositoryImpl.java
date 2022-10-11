package com.ozu.cs393.examples.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
	@Value("jbdc:oracle")
	private String url;
	
	@Value("admin")
	private String username;
	
	@Value("123")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public double getPriceFor(int code) {

		return 345.56;
	}

}
