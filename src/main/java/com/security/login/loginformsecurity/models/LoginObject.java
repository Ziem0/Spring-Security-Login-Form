package com.security.login.loginformsecurity.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class LoginObject {

	@Id
	private String username;
	@NotNull
	private String password;
	@NotNull
	private boolean enabled;

	public LoginObject(String username, String password, boolean enabled) {
		this.username = username;
		this.password =passwordEncoder().encode(password);
		this.enabled = enabled;
	}

	public LoginObject() {
	}

	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}