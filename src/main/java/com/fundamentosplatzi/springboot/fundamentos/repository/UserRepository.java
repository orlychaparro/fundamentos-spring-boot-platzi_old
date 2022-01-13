package com.fundamentosplatzi.springboot.fundamentos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("Select u from User u WHERE u.email=?1")
	Optional<User> findByUserEmail(String email);
	
	@Query("SELECT u from User u where u.name like ?1%")
	List<User> findandSort(String name, Sort sort);
	
	List<User> findByName(String name);
	
	
	Optional<User> findByEmailAndName(String email, String name);
	
	List<User> findByNameLike(String name);
	
	List<User> findByNameOrEmail(String name,String email);
	
	List<User> findByBirthdateBetween(LocalDate begin, LocalDate end);
	
	List<User> findByNameLikeOrderByIdDesc(String name);
	
	List<User> findByNameContainingOrderByIdDesc(String name);
	

}
