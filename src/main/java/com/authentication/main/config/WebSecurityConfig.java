package com.authentication.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authentication.main.valitation.UsuarioDetails;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UsuarioDetails userDetails;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public WebSecurityConfig(UsuarioDetails userDetails)
	{
		this.userDetails = userDetails;
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/").permitAll().and()
		.formLogin().
			loginPage("/").
			loginProcessingUrl("/appLogin").
			usernameParameter("app_username").
			passwordParameter("app_password").
			defaultSuccessUrl("/userController/")
			.failureUrl("/?error").permitAll().and()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/?logout");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
	}
}
