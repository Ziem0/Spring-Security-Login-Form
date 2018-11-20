package com.security.login.loginformsecurity;

import com.security.login.loginformsecurity.models.LoginObject;
import com.security.login.loginformsecurity.models.Role;
import com.security.login.loginformsecurity.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class LoginFormSecurityApplication {

	@Autowired
	MainService service;

	public static void main(String[] args) {
		SpringApplication.run(LoginFormSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args -> {
			LoginObject ziemo = service.save(new LoginObject("ziemo", "1212", true));
			LoginObject ania = service.save(new LoginObject("ania", "1212", false));
			LoginObject nina = service.save(new LoginObject("nina", "1212", true));
			service.saveRole(new Role(ziemo, com.security.login.loginformsecurity.helper.Role.ROLE_ADMIN));
			service.saveRole(new Role(ania, com.security.login.loginformsecurity.helper.Role.ROLE_USER));
			service.saveRole(new Role(nina, com.security.login.loginformsecurity.helper.Role.ROLE_USER));
		});
	}


}
