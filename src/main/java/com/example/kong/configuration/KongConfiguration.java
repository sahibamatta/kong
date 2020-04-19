package com.example.kong.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class KongConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{

		 http.cors().and().csrf().disable()
		 .authorizeRequests()
         .antMatchers("/private/**")
         .authenticated()
         .antMatchers("/public/**")
         .permitAll()
         .and()
         .httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception 
	{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password(encoder.encode("password"))
		.roles("USER");
	}
}