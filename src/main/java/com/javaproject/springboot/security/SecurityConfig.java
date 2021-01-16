package com.javaproject.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// Login using oauth2
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//			.antMatcher("/**").authorizeRequests()
//			.antMatchers("/").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.oauth2Login();
//		
//	}
	
	// Building a authentication manager for all ready defined users

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		//configuring authentication object
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("admin_password")
			.roles("ADMIN");
				
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.authorizeRequests()
				.antMatchers("/api/**")
				.hasAnyRole("ADMIN","USER")
				.and()
				.formLogin();
		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


	
}
