package com.fundamentosplatzi.springboot.fundamentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;

import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.custom.MyCustomDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	
	
	private MyBeanWithDependency myBeanWithDependency;
	private MyCustomDependency myCustomDependency;
	
	public FundamentosApplication(@Qualifier("componetTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyCustomDependency myCustomDependency) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomDependency = myCustomDependency;
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
	}

}
