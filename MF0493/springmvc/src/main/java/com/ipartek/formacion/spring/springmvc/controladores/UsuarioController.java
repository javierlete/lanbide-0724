package com.ipartek.formacion.spring.springmvc.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.spring.springmvc.entidades.Usuario;
import com.ipartek.formacion.spring.springmvc.repositorios.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/registro")
	public String registro(Usuario usuario) {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registroPost(@Valid Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "registro";
		}
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		repo.save(usuario);
		
		return "redirect:/login";
	}
}
