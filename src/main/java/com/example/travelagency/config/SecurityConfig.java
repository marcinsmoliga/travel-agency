package com.example.travelagency.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final DataSource dataSource;

	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public PasswordEncoder passwordEncoder( ){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT login, password, enabled FROM user WHERE login=?")
				.authoritiesByUsernameQuery("SELECT login, role FROM role WHERE login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/login")
					.permitAll()
				.antMatchers("/addTour", "/editTour")
					.hasAnyRole( "EMPLOYEE")
				.antMatchers("/deleteTour")
					.hasAnyRole("ADMIN")
				.antMatchers("/addComment", "/addUserToTour")
					.hasAnyRole("CLIENT")
				.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/checkUserAccount")
					.defaultSuccessUrl("/")
					.permitAll()
				.and()
					.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true)
					.permitAll()
				.and()
					.exceptionHandling().accessDeniedPage("/forbidden");
		http.csrf().disable();
	}
}
