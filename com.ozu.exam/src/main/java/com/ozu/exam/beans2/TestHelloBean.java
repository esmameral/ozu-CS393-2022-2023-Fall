package com.ozu.exam.beans2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozu.exam.Application;



public class TestHelloBean {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		
		HelloBean bean1=context.getBean("helloBean", HelloBean.class);
		HelloBean bean2=context.getBean("helloBean", HelloBean.class);
		System.out.println(bean1.getMessage());
		System.out.println(bean2.getMessage());
		
		bean2.setMessage("Hi, how are you?");
		System.out.println(bean1.getMessage());
		System.out.println(bean2.getMessage());
		
		
	}

}
