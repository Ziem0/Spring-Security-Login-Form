package com.security.login.loginformsecurity.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne
	private LoginObject loginObject;
	@Enumerated(EnumType.STRING)
	private com.security.login.loginformsecurity.helper.Role role;

	public Role(LoginObject loginObject, com.security.login.loginformsecurity.helper.Role role) {
		this.loginObject = loginObject;
		this.role = role;
	}

	public Role() {
	}

}
