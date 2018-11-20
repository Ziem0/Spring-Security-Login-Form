package com.security.login.loginformsecurity.services;

import com.security.login.loginformsecurity.models.LoginObject;
import com.security.login.loginformsecurity.models.Role;
import com.security.login.loginformsecurity.repository.LoginRepo;
import com.security.login.loginformsecurity.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {

	final
	LoginRepo loginRepo;

	final
	RoleRepo roleRepo;

	@Autowired
	public MainService(LoginRepo loginRepo, RoleRepo roleRepo) {
		this.loginRepo = loginRepo;
		this.roleRepo = roleRepo;
	}

	public Optional<LoginObject> checkUsernameAndPassword(String username, String password) {
		return loginRepo.getByUsernameAndPassword(username, password);
	}

	public LoginObject save(LoginObject loginObject) {
		return loginRepo.save(loginObject);
	}

	public void saveRole(Role role) {
		roleRepo.save(role);
	}
}
