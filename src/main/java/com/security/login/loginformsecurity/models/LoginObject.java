package com.security.login.loginformsecurity.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginObject {

	private String username;
	private String password;

	public LoginObject(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginObject() {
	}
}
