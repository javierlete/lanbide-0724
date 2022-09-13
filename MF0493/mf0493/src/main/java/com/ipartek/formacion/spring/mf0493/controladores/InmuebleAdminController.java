package com.ipartek.formacion.spring.mf0493.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.servicios.InmuebleAdminService;

@Controller
@RequestMapping("/admin")
public class InmuebleAdminController {
	@Autowired
	private InmuebleAdminService servicio;
	
	@GetMapping
	public String listar(Model modelo) {
		modelo.addAttribute("listaInmueblesAdmin", servicio.listado());
		return "admin"; 
	}
	
	@GetMapping("/alta")
	public String alta(Inmueble inmueble) {
		return "alta";
	}
	
	@PostMapping("/alta")
	public String altaPost(Inmueble inmueble) {
		servicio.alta(inmueble);
		
		return "redirect:/admin";
	}
}
