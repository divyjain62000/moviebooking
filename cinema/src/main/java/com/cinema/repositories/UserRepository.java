package com.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.entities.*;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByEmail(String email);
	User findByMobileNumber(String mobileNumber);
	
}
