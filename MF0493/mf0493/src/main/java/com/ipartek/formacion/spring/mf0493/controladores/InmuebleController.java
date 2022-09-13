package com.ipartek.formacion.spring.mf0493.controladores;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;
import com.ipartek.formacion.spring.mf0493.servicios.InmuebleService;

@Controller
@RequestMapping("/")
public class InmuebleController {
	@Autowired
	private InmuebleService servicio;
	
	@GetMapping
	public String index(Model modelo, Tipo tipo, BigDecimal min, BigDecimal max, String texto) {
		Iterable<Inmueble> inmuebles;
		
		if(tipo != null) {
			inmuebles = servicio.alquilerVentaOTodas(tipo);
		} else if(min != null && max != null) {
			inmuebles = servicio.rangoDePrecio(min, max);
		} else if(texto != null) {
			inmuebles = servicio.nombreODireccion(texto);
		} else {
			inmuebles = servicio.alquilerVentaOTodas(null);	
		}
		
		modelo.addAttribute("listaInmuebles", inmuebles);
		return "index";
	}
}
