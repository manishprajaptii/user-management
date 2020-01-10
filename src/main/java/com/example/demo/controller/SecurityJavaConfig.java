package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sun.xml.fastinfoset.Encoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder =
	  PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
		auth
	  .inMemoryAuthentication() .withUser("user2")
	  .password(encoder.encode("password")) .roles("USER") 
		.and()
	  .withUser("admin") .password(encoder.encode("admin")) .roles("USER",
	  "ADMIN"); 
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
