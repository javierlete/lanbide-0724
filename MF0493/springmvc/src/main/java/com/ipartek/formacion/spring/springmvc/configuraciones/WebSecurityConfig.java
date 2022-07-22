package com.ipartek.formacion.spring.springmvc.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// AUTORIZACIÓN
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// A las rutas "/admin/LO/QUE/SEA" sólo se les permite el acceso a usuarios autenticados
				// ** significa cualquier nivel de anidación
				// * significa sólo a ese nivel
				.antMatchers("/admin/**").authenticated()
				// Al resto de peticiones se les permite el acceso, sean anónimas o no
				.anyRequest().permitAll()
				// A las rutas "/" o "/home" se les permite el acceso a cualquiera
				// .antMatchers("/", "/home").permitAll()
				// Al resto de peticiones, sólo se le permite el acceso a usuarios autenticados
				// .anyRequest().authenticated()
				.and()
			.formLogin()
				//.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	// AUTENTICACIÓN
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("contra")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}