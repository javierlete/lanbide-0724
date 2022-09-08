package com.ipartek.formacion.spring.restaurantapp.controladoresrest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;
import com.ipartek.formacion.spring.restaurantapp.repositorios.ReservaRepository;

@RestController
public class ReservaV2RestController {
	@Autowired
	private ReservaRepository repo;
	
	@GetMapping("/api/v2/reservas/{telefono}_{fechaHora}")
	public Reserva buscarPorTelefonoYFechaHora(@PathVariable String telefono, @PathVariable LocalDateTime fechaHora) {
		return repo.findByTelefonoAndFechaHora(telefono, fechaHora);
	}
}
