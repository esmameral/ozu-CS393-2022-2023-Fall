package com.ozu.exam.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozu.exam.Application;

public class TestMessageBean {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		
		MessageBean messageBean1=context.getBean("firstBean", MessageBean.class);
		System.out.println(messageBean1.getMessage());
		
		messageBean1.setMessage("Good evening");
		System.out.println(messageBean1.getMessage());
		
		MessageBean messageBean2=context.getBean("secondBean", MessageBean.class);
		System.out.println(messageBean2.getMessage());
		System.out.println(messageBean1.getMessage());
	}

}
