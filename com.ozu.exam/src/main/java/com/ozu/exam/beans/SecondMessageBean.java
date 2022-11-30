package com.ozu.exam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("secondBean")
public class SecondMessageBean implements MessageBean {

	@Value("Good evening")
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
