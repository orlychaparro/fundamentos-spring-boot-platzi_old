package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDepenencyImplement implements MyBeanWithDependency {
	
	
	private MyOperation myOperation;
	
	public MyBeanWithDepenencyImplement(MyOperation myOperation) {
		// TODO Auto-generated constructor stub
		this.myOperation = myOperation;
	}
	
	@Override
	public void printWithDependency() {
		// TODO Auto-generated method stub
		int numero = 1;
		System.out.println(myOperation.sum(numero));
		System.out.println("Hola implementacion bean con dependencia");
	
	
	}

}
