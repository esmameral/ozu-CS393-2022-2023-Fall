package com.ozu.exam.beans2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozu.exam.Application;



public class TestMyBean {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		
		MyBean myBean1=context.getBean("myBean", MyBean.class);
		System.out.println(myBean1.getMessage());
		
		myBean1.setMessage("Good evening");
		System.out.println(myBean1.getMessage());
		
		MyBean myBean2=context.getBean("myBean", MyBean.class);
		System.out.println(myBean2.getMessage());
		System.out.println(myBean1.getMessage());
	}

}
