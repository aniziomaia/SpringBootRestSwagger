package com.eventos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	        .anyRequest().authenticated()
	        .antMatchers(HttpMethod.GET, "/**").permitAll()
	        .and()
	        .httpBasic()
	        .and()
	        .antMatcher("/**")
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.NEVER)
	        .and()
	        .csrf().disable();
	}
	
	
}
