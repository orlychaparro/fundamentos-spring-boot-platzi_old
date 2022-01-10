package com.fundamentosplatzi.springboot.fundamentos.custom;

import org.springframework.stereotype.Component;

@Component
public class MyCustomDependencyImplement implements MyCustomDependency {
	@Override
	public void ImprimeCustomDependency() {
		// TODO Auto-generated method stub
		System.out.println("Imprime My custom dependency");
	}

}
