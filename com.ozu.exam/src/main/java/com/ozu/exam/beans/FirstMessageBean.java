package com.ozu.exam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("firstBean")
public class FirstMessageBean implements MessageBean  {

	@Value("Good morning")
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
}
