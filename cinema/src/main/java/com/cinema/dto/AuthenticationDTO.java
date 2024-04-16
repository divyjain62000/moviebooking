package com.cinema.dto;

import java.io.*;

public class AuthenticationDTO implements Serializable {
	String email;
	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationDTO [email=" + email + ", password=" + password + "]";
	}

}
