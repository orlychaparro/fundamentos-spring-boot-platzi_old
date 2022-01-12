package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDepenencyImplement implements MyBeanWithDependency {
	
	 Log LOGGER = LogFactory.getLog(MyBeanWithDepenencyImplement.class);
	
	private MyOperation myOperation;
	
	public MyBeanWithDepenencyImplement(MyOperation myOperation) {
		// TODO Auto-generated constructor stub
		this.myOperation = myOperation;
	}
	
	@Override
	public void printWithDependency() {
		// TODO Auto-generated method stub
		LOGGER.info("Hemos ingresado al metodo printWithDependency");
		int numero = 1;
		LOGGER.debug("El numero parametro de la dependencia operacion es vv **************** : " + numero);
		System.out.println(myOperation.sum(numero));
		System.out.println("Hola implementacion bean con dependencia");
	
	
	}

}
