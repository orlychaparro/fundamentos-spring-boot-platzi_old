package com.fundamentosplatzi.springboot.fundamentos.service;

import org.apache.commons.logging.LogFactory;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;


import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

@Service
public class UserService {
	
	private final Log  LOG= LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	@Transactional
	public void saveTransactional(List<User> users) {
		users.stream()
			 .peek(user -> LOG.info("Usuario Insertado: " + user))
			 .forEach(userRepository::save);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	public User save(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(new User(id));
		
	}
	
	/*
	 * public User update(User newUser, Long id){ return
	 * userRepository.findById(id).map(user -> { user.setEmail(newUser.getEmail());
	 * user.setBirthdate(newUser.getBirthdate()); user.setName(newUser.getName());
	 * return userRepository.save(user); }).orElse(null); }
	 */
	
	
	
	  public User update(User newUser, Long id) { 
		  return 
			   userRepository.findById(id) 
				  .map( 
						  user ->{
					  
					  			user.setEmail(newUser.getEmail()); 
					  			user.setBirthdate(newUser.getBirthdate());
					  			user.setName(newUser.getName()); 
					  			return userRepository.save(user); 
						  	}
	  
					  ).get();
	  
	  }
	 

}
