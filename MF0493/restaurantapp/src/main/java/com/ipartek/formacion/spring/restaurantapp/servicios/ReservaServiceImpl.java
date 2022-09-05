package com.ipartek.formacion.spring.restaurantapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;
import com.ipartek.formacion.spring.restaurantapp.repositorios.ReservaRepository;

import lombok.extern.java.Log;

@Log
@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository repo;
	
	@Override
	public Iterable<Reserva> listar() {
		log.info("Se ha pedido un listado de reservas");
		return repo.findAll();
	}

	@Override
	public Reserva crear(Reserva reserva) {
		log.info("Se va a crear una reserva " + reserva);
		Reserva nueva = repo.save(reserva);
		log.info("Se ha creado la reserva " + nueva);
		
		return nueva;
	}

}
