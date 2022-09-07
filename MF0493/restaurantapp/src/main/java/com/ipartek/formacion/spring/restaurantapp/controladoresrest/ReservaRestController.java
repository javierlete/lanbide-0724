package com.ipartek.formacion.spring.restaurantapp.controladoresrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;
import com.ipartek.formacion.spring.restaurantapp.repositorios.ReservaRepository;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaRestController {
	@Autowired
	private ReservaRepository repo;
	
	@GetMapping
	public Iterable<Reserva> get() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public Reserva get(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva post(@RequestBody Reserva reserva) {
		return repo.save(reserva);
	}
	
	@PutMapping("{id}")
	public Reserva put(@RequestBody Reserva reserva, @PathVariable Long id) {
		if(reserva.getId() != id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return repo.save(reserva);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
