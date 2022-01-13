package com.fundamentosplatzi.springboot.fundamentos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.custom.MyCustomDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	
	
	private MyBeanWithDependency myBeanWithDependency;
	private MyCustomDependency myCustomDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	
	public FundamentosApplication(@Qualifier("componetTwoImplement") ComponentDependency componentDependency, MyBean myBean,
			                                  MyBeanWithDependency myBeanWithDependency, MyCustomDependency myCustomDependency, 
			                                  MyBeanWithProperties myBeanWithProperties,UserPojo userPojo,
			                                  UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomDependency = myCustomDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		ejemplosAnteriores();	
		saveUsersInDatabase();
		getInformationJpqlFromUser();

	}
	
	private void getInformationJpqlFromUser() {
		//userRepository.findByUserEmail("juan2@gmail.com");
		LOGGER.info("El usuario con el metodo findByUserEmail : " + 
				userRepository.findByUserEmail("Juan2@gmail.com")
			   .orElseThrow(()-> new RuntimeException("No se encontro el usuario")));
		
	userRepository.findandSort("Juan", Sort.by("id").descending())
				  .stream()
				  .forEach(user-> LOGGER.info("Usuario con metodo sort " + user));
		
		
	}
	
	private void saveUsersInDatabase() {
		User user1 = new User("Juan1", "juan1@gmail.com", LocalDate.of(1975,02,1));
		User user2 = new User("Juan2", "Juan2@gmail.com", LocalDate.of(1975,02,2));
		User user3 = new User("Juan3", "Juan3@gmail.com", LocalDate.of(1975,02,3));
		User user4 = new User("Juan4", "Juan4@gmail.com", LocalDate.of(1975,02,4));
		User user5 = new User("Juan5", "Juan5@gmail.com", LocalDate.of(1975,02,5));
		User user6 = new User("Juan6", "Juan6@gmail.com", LocalDate.of(1975,02,6));
		User user7 = new User("Juan7", "Juan7@gmail.com", LocalDate.of(1975,02,7));
		User user8 = new User("Juan8", "Juan8@gmail.com", LocalDate.of(1975,02,8));
		User user9 = new User("Juan9", "Juan9@gmail.com", LocalDate.of(1975,02,9));
		User user10 = new User("Juan10", "Juan10@gmail.com", LocalDate.of(1975,02,10));
		User user11 = new User("Juan11", "Juan11@gmail.com", LocalDate.of(1975,02,11));
		User user12 = new User("Juan12", "Juan12@gmail.com", LocalDate.of(1975,02,12));
		
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12);
		list.stream().forEach(userRepository::save);

	}
	
	
	private void ejemplosAnteriores() {
		
		// Se corto el contenido usado en las clases de inyeccion de dependencias }
		// y se ego aca
		
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		myCustomDependency.ImprimeCustomDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println("email: "+ userPojo.getEmail() + ", pass: " + userPojo.getPassword() + " ,edad: "+ userPojo.getAge());
		try {
			//error
			//int value = 10/0;
			
		}catch (Exception e){
			LOGGER.error("Error:" + e);	
			LOGGER.error("Error:" + e.getStackTrace());	
		}
	}

}
