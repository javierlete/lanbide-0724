package com.ipartek.formacion.spring.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.springmvc.dtos.UsuarioRol;
import com.ipartek.formacion.spring.springmvc.entidades.Factura;
import com.ipartek.formacion.spring.springmvc.entidades.FacturaLinea;
import com.ipartek.formacion.spring.springmvc.entidades.Usuario;
import com.ipartek.formacion.spring.springmvc.repositorios.FacturaRepository;
import com.ipartek.formacion.spring.springmvc.repositorios.UsuarioRepository;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner { // implements CommandLineRunner es para disponer de un "main" de consola
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private FacturaRepository repoFactura;
	
	// Este funcionaría como un main de consola
	@Override
	public void run(String... args) throws Exception {
		System.out.println("EN CONSOLA");
		
		for(Factura f: repoFactura.findAll()) {
			System.out.println(f);
		}
		
		Factura factura = repoFactura.findById(1L).orElse(null);

		System.out.println(factura);
		System.out.println(factura.getCliente());
		System.out.println(factura.getCliente().getUsuario());
		System.out.println(factura.getCliente().getUsuario().getRol());
		
		for(FacturaLinea l: factura.getLineas()) {
			System.out.println(l.getProducto());
			System.out.println(l.getCantidad());
		}
		
		Usuario porNick = repoUsuario.findByNick("javier");
		
		System.out.println(porNick);
		System.out.println(porNick.getRol());
		System.out.println(porNick.getCliente());
		
		UsuarioRol usuarioRol = repoUsuario.obtenerUsuarioRol("javier");
		
		System.out.println(usuarioRol);
		
		Usuario usuario = repoUsuario.findById(1L).orElse(null);
		
		System.out.println(usuario);
		System.out.println(usuario.getRol());
		
		for(Usuario u: repoUsuario.obtenerTodosConRol()) {
			System.out.println(u);
			System.out.println(u.getRol());
		}
	}
}
