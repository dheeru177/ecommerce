package com.shopme.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("all")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		
		
	return new BCryptPasswordEncoder();	
		
	}
	
	
	
	
	
	@Override
	public void configure(HttpSecurity http ) throws Exception{
		
	http.authorizeRequests().anyRequest().permitAll();	
		
		
		
		
	}

}
