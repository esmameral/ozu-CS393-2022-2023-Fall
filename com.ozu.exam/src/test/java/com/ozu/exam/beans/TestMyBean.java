package com.ozu.exam.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.exam.q4.MyBean;
@SpringBootTest
class TestMyBean {

	@Autowired
	MyBean myBean;

	@Test
	void test() {
		System.out.println(myBean.getMessage());
		
	}

}
