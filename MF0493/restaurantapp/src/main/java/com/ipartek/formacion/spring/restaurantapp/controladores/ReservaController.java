package com.ipartek.formacion.spring.restaurantapp.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;
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
	
	@GetMapping("/crear")
	public String crear(Reserva reserva) {
		// reserva.setNombre("Prueba");
		return "reserva";
	}
	
	@PostMapping("/crear")
	// @Valid hace que se valide el objeto reserva por medio de todos los atributos
	// de validación de la entidad (@NotBlank...)
	// BindingResult nos da el resultado de la validación
	public String crear(@Valid Reserva reserva, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "reserva";
		}
		
		servicio.crear(reserva);
		
		return "redirect:/reserva/listar";
	}
}
