package com.cinema.services;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dto.AuthenticationDTO;
import com.cinema.entities.User;
import com.cinema.exceptions.CustomException;
import com.cinema.repositories.UserRepository;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) throws CustomException {
		CustomException ce=new CustomException();
		User u1=this.userRepository.findByEmail(user.getEmail());
		if(u1!=null) {
			ce.addException("email","Email already exists");
		}
		User u2=this.userRepository.findByMobileNumber(user.getMobileNumber());
		if(u2!=null) {
			ce.addException("mobileNumber","Mobile number already exists");
		}
		if(!ce.getExceptions().isEmpty() ) {
			throw ce;
		}
		User createdUser = this.userRepository.save(user);
		return createdUser;
	}

	@Override
	public User login(AuthenticationDTO authenticationDTO) throws AuthenticationException {
		User user = this.userRepository.findByEmail(authenticationDTO.getEmail());
		if (user == null) {
			throw new AuthenticationException();
		}
		if (!user.getPassword().equals(authenticationDTO.getPassword())) {
			throw new AuthenticationException();
		}
		return user;
	}

}
