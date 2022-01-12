package com.fundamentosplatzi.springboot.fundamentos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.custom.MyCustomDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	
	
	private MyBeanWithDependency myBeanWithDependency;
	private MyCustomDependency myCustomDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	
	public FundamentosApplication(@Qualifier("componetTwoImplement") ComponentDependency componentDependency, MyBean myBean,
			                                  MyBeanWithDependency myBeanWithDependency, MyCustomDependency myCustomDependency, 
			                                  MyBeanWithProperties myBeanWithProperties,UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomDependency = myCustomDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		myCustomDependency.ImprimeCustomDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println("email: "+ userPojo.getEmail() + ", pass: " + userPojo.getPassword() + " ,edad: "+ userPojo.getAge());
		try {
			//error
			int value = 10/0;
			
		}catch (Exception e){
			LOGGER.error("Error:" + e);	
			LOGGER.error("Error:" + e.getStackTrace());	
		}
		
		
	}

}
