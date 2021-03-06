package com.security.login.loginformsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.inMemoryAuthentication()
//				.withUser("ziemo")
//				.password(passwordEncoder().encode("1212"))
//				.roles("ADMIN")
//				.and()
//				.withUser("ania")
//				.password(passwordEncoder().encode("1212"))
//				.roles("USER");


		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
//				.usersByUsernameQuery("select username,password, enabled from users where username=?")
//				.passwordEncoder(passwordEncoder())
//				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

				.usersByUsernameQuery("select username, password, enabled from login_object where username=?")
				.passwordEncoder(passwordEncoder())
				.authoritiesByUsernameQuery("select login_object_username, role from role where login_object_username=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/all")
					.permitAll()
				.antMatchers("/admin")
					.hasRole("ADMIN")
				.antMatchers("/user")
					.hasRole("USER")
				.antMatchers("/anonim")
					.anonymous()
				.anyRequest().permitAll()
				.and()
				.formLogin()
					.loginPage("/login")
//					.defaultSuccessUrl("/result", true)
//					.loginProcessingUrl("/result")
//					.defaultSuccessUrl("/anonim")
//					.failureUrl("/anonim")
//					.permitAll()
				.and()
				.logout()
					.permitAll()
					.and().rememberMe()
						.tokenValiditySeconds(5).and()
				.csrf().disable();
	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
