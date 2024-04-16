package com.cinema.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.AuthenticationDTO;
import com.cinema.entities.User;
import com.cinema.exceptions.CustomException;
import com.cinema.services.UserService;
import java.util.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users")
	public ResponseEntity<?> create(@RequestBody User user) {
		try {
			User u = this.userService.create(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		} catch (CustomException ce) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ce.getExceptions());
		}
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO) {
		try {
			User user=this.userService.login(authenticationDTO);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (AuthenticationException ae) {
			Map<String, String> errMap = new HashMap<>();
			errMap.put("message", "Invalid email or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errMap);
		}
	}

}
