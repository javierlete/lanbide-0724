package com.ipartek.formacion.spring.mf0493.controladores.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;
import com.ipartek.formacion.spring.mf0493.servicios.InmuebleService;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleRestController {
	@Autowired
	private InmuebleService servicio;
	
	@GetMapping
	public Iterable<Inmueble> listado() {
		return servicio.alquilerVentaOTodas(null);
	}
	
	@GetMapping("/search/alquilerVentaOTodas")
	public Iterable<Inmueble> alquilerVentaOTodas(Tipo tipo) {
		return servicio.alquilerVentaOTodas(tipo);
	}
	
	@GetMapping("/search/nombreODireccion")
	public Iterable<Inmueble> nombreODireccion(String texto) {
		return servicio.nombreODireccion(texto);
	}
	
	@GetMapping("/search/rangoDePrecio")
	public Iterable<Inmueble> rangoDePrecio(BigDecimal min, BigDecimal max) {
		return servicio.rangoDePrecio(min, max);
	}
}
