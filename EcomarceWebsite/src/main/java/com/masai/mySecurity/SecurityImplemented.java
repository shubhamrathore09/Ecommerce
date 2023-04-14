package com.masai.mySecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityImplemented {
	
	@Bean
	public SecurityFilterChain mySecurity(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
		.requestMatchers("/customer/add").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.httpBasic()
		.and()
		.formLogin();
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
