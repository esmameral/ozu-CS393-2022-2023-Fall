package com.ozu.cs393.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.cs393.examples.greeting.GreetingService;

@RestController
public class HelloBean {
	@Autowired
	private GreetingService greetingService;
	
	@RequestMapping("/sayHello")
	public String sayGreeting() {
		return greetingService.sayGreeting("Emir");
	}
}
