package com.ipartek.formacion.spring.springmvc.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
				.antMatchers("/admin/**").authenticated()
				// Al resto de peticiones se les permite el acceso, sean anónimas o no
				.anyRequest().permitAll()
				// A las rutas "/" o "/home" se les permite el acceso a cualquiera
				// .antMatchers("/", "/home").permitAll()
				// Al resto de peticiones, sólo se le permite el acceso a usuarios autenticados
				// .anyRequest().authenticated()
            )
            .formLogin()
				//.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	        return http.build();
    }

    // AUTENTICACIÓN
    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("contra")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}