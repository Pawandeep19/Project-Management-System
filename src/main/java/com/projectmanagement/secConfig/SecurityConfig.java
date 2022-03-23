/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* SecurityConfig class extending WebSecurityConfigurerAdapter:
* for security configuration of spring security for authentication and authorization
* --------------------------------------------------------------------------------------------------
*/
package com.projectmanagement.secConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/**Constructor Autowiring Reference of UserDetailsService interface to apply user related business logic operations*/
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	* @param AuthenticationManagerBuilder (auth)
	* method used for authentication of user
	*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
     
	/**
	* @param HttpSecurity (http)
	* method used for authorization of user
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home/**").hasAnyRole("ADMIN")
		.antMatchers("/addproject/**").hasAnyRole("ADMIN")
		.antMatchers("/updateProject/**").hasAnyRole("ADMIN")
		.antMatchers("/deleteProject/**").hasAnyRole("ADMIN")
		.antMatchers("/changepwd/**").hasAnyRole("ADMIN")
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/projectlogin")
		.usernameParameter("uname").passwordParameter("upass")
		.defaultSuccessUrl("/home?success=Sign-In Successful")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
		
		http
        .logout(logout -> logout
          .logoutUrl("/logout")
          .permitAll()
          .addLogoutHandler(new SecurityContextLogoutHandler())
        );
  }

	/** Bean Wiring for PasswordEncoder*/
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder(); 
	}
	
}
