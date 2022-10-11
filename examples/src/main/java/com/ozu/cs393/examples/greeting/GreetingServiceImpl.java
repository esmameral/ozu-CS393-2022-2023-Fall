package com.ozu.cs393.examples.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("greetingService")
public class GreetingServiceImpl implements GreetingService {

	
	
	//@Value("Hi, how are you?")
	@Value("${greeting.message}")
	private String greetingMessage;
    
    
	public String getGreetingMessage() {
		return greetingMessage;
	}

	@Override
	public void setGreetingMessage(String message) {
		this.greetingMessage=message;
	
	}

	@Override
	public String sayGreeting(String name) {
		if(name!=null||name.length()!=0) {
			return greetingMessage+ " "+name;
		}
		
		return greetingMessage;
	}

}
