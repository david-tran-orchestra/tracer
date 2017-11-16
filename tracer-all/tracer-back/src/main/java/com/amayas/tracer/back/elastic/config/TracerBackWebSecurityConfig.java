package com.amayas.tracer.back.elastic.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;



@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class TracerBackWebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
		
//		http.x509();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

}
