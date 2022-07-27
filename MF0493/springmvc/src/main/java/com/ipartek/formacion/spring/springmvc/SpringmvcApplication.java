package com.ipartek.formacion.spring.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.springmvc.entidades.Usuario;
import com.ipartek.formacion.spring.springmvc.repositorios.UsuarioRepository;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner { // implements CommandLineRunner es para disponer de un "main" de consola
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Autowired
	private UsuarioRepository repoUsuario;
	
	// Este funcionaría como un main de consola
	@Override
	public void run(String... args) throws Exception {
		System.out.println("EN CONSOLA");
		
		Usuario usuario = repoUsuario.findById(1L).orElse(null);
		
		System.out.println(usuario);
		
		for(Usuario u: repoUsuario.obtenerTodosConRol()) {
			System.out.println(u);
			System.out.println(u.getRol());
		}
	}
}
