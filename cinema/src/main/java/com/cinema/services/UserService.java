package com.cinema.services;

import javax.naming.AuthenticationException;

import com.cinema.dto.AuthenticationDTO;
import com.cinema.entities.User;
import com.cinema.exceptions.CustomException;

public interface UserService {
	User create(User user) throws CustomException;
	User login(AuthenticationDTO authenticationDTO) throws AuthenticationException;
}
