package com.fundamentosplatzi.springboot.fundamentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	
	public FundamentosApplication(@Qualifier("componetTwoImplement") ComponentDependency componentDependency, MyBean myBean) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		componentDependency.saludar();
		myBean.print();
	}

}
