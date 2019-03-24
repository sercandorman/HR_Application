package com.crudwithspring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select USERNAME, PASSWORD, 1 as enabled from USER_AND_ROLE where USERNAME=?")
				.authoritiesByUsernameQuery("select USERNAME, ROLE from USER_AND_ROLE where USERNAME=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/oneList").permitAll()
		.antMatchers("/homepage").permitAll()
		.antMatchers("/appyly").permitAll()
		.antMatchers("/createList").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/deleteList").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/editList").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/detailList").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/applications").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/deleteJob").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/createJob").access("hasRole('ROLE_ADMIN')").and()
				.formLogin().loginProcessingUrl("/login").loginPage("/login").defaultSuccessUrl("/homepage")
				.failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password").and()
				.logout()
				.logoutUrl("/logout") 
				.logoutSuccessUrl("/homepage")
	            .and().csrf().disable();
	}
}