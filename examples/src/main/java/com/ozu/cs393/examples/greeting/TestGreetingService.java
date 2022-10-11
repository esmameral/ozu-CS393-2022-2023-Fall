package com.ozu.cs393.examples.greeting;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozu.cs393.examples.Application;

public class TestGreetingService {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		
		GreetingService greeting=context.getBean("greetingService", GreetingService.class);
		System.out.println(greeting.sayGreeting("Kerem"));
		greeting.setGreetingMessage("Gunaydin");
		System.out.println(greeting.sayGreeting("Kerem"));
		GreetingService greeting2=context.getBean("greetingService", GreetingService.class);
		System.out.println(greeting2.sayGreeting("Elif"));
		
	}

}
