package com.ozu.exam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("firstBean")
@Primary
public class FirstMyBeanImpl implements MyBean  {

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
