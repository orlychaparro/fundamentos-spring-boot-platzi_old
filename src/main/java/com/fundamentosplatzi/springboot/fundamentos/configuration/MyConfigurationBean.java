package com.fundamentosplatzi.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean2Implement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanImplement;

@Configuration
public class MyConfigurationBean {
	
	@Bean
	public MyBean beanOperation() {
		// se especifica cual implementacion usar
		//return new MyBeanImplement();
		return new MyBean2Implement();
		
	}
	
}
