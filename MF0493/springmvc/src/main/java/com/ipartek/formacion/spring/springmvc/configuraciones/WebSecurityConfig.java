package com.ipartek.formacion.spring.springmvc.configuraciones;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// AUTORIZACIÓN
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
        		// A las rutas "/admin/LO/QUE/SEA" sólo se les permite el acceso a usuarios autenticados
				// ** significa cualquier nivel de anidación
				// * significa sólo a ese nivel
				.antMatchers("/admin/**").hasRole("ADMIN")
				// Al resto de peticiones se les permite el acceso, sean anónimas o no
				.anyRequest().permitAll()
				// A las rutas "/" o "/home" se les permite el acceso a cualquiera
				// .antMatchers("/", "/home").permitAll()
				// Al resto de peticiones, sólo se le permite el acceso a usuarios autenticados
				// .anyRequest().authenticated()
            )
            .formLogin()
				.loginPage("/login") // Sustituye el login por defecto por un controlador creado por nosotros para la petición GET
				.permitAll()
				.and()
			.logout()
				.permitAll();
	        return http.build();
    }

    // AUTENTICACIÓN
	@Bean
    UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        
        jdbc.setUsersByUsernameQuery("SELECT nick AS username, password, TRUE FROM usuarios WHERE nick = ?");
        jdbc.setRolePrefix("ROLE_");
        jdbc.setAuthoritiesByUsernameQuery("SELECT nick AS username, rol AS authority FROM usuarios WHERE nick = ?");
        
        return jdbc;
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
	    return new BCryptPasswordEncoder();
	}
	
	// https://bcrypt.online/
	
//	create table users(
//		username varchar(50) not null primary key,
//		password varchar(50) not null,
//		enabled boolean not null
//	);
//
//	create table authorities (
//		username varchar(50) not null,
//		authority varchar(50) not null,
//		constraint fk_authorities_users foreign key(username) references users(username)
//	);
//	create unique index ix_auth_username on authorities (username,authority);

}