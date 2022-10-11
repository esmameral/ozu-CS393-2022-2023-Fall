package com.ozu.cs393.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ozu.cs393.examples.repo.ProductRepository;
@Service("productService")
@Scope("prototype")
public class ProductServiceImpl implements ProductService {
    @Autowired
	ProductRepository productRepository;
    @Value("12.5")
    double rate;
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double getPrice(int code) {
		double price=productRepository.getPriceFor(code);
		price+=price*rate;
		return price;
	}

}
