package com.fundamentosplatzi.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean2Implement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDepenencyImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {
	
	@Bean
	public MyBean beanOperation() {
		// se especifica cual implementacion usar
		//return new MyBeanImplement();
		return new MyBean2Implement();
		
	}
	
	@Bean
	public MyOperation beanOperationOperation() {
		// se especifica cual implementacion usar
		//return new MyBeanImplement();
		return new MyOperationImplement();
		
	}
	
	@Bean
	public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
		// se especifica cual implementacion usar
		//return new MyBeanImplement();
		return new MyBeanWithDepenencyImplement(myOperation);
		
	}
	
}
