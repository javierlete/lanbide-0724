package com.ipartek.formacion.spring.mf0493.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.servicios.InmuebleAdminService;

@RestController
@RequestMapping("/api/admin/inmuebles")
public class InmuebleAdminRestController {
	@Autowired
	private InmuebleAdminService servicio;
	
	@GetMapping
	public Iterable<Inmueble> listado() {
		return servicio.listado();
	}
	
	@PostMapping
	public Inmueble alta(Inmueble inmueble) {
		return servicio.alta(inmueble);
	}
}
