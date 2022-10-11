package com.ozu.cs393.examples.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozu.cs393.examples.Application;

public class TestProductService {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		
		ProductService productService =context.getBean("productService", ProductService.class);
		System.out.println(productService.getPrice(19));
		
		ProductService productService2 =context.getBean("productService", ProductService.class);
		System.out.println(productService2.getPrice(19));
		productService2.setRate(20);
		System.out.println(productService2.getPrice(19));
		System.out.println(productService.getPrice(19));
		//if we use "prototype" scope in the ProductServiceImpl, each time spring will 
		//create a new instance for ProductService. 
		//This time following expression will produce false.
		System.out.println(productService==productService2);
	}

}
