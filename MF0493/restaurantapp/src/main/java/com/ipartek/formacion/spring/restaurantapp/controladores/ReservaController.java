package com.ipartek.formacion.spring.restaurantapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.restaurantapp.servicios.ReservaService;

// Usuario por defecto: user
// Password por defecto: mirar consola

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	@Autowired
	private ReservaService servicio;
	
//	@ModelAttribute("reservas")
//	public Iterable<Reserva> reservas() {
//		return servicio.listar();
//	}
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("reservas", servicio.listar());
		
		return "listado";
	}
}
