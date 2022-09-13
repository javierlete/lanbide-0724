package com.ipartek.formacion.spring.mf0493.servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;
import com.ipartek.formacion.spring.mf0493.repositorios.InmuebleRepository;

@Service
public class InmuebleServiceImpl implements InmuebleService {
	@Autowired
	private InmuebleRepository repo;
	
	@Override
	public Iterable<Inmueble> rangoDePrecio(BigDecimal min, BigDecimal max) {
		return repo.findByPrecioBetween(min, max);
	}

	@Override
	public Iterable<Inmueble> alquilerVentaOTodas(Tipo tipo) {
		if(tipo == null) {
			return repo.findAll();
		}
		return repo.findByTipo(tipo);
	}

	@Override
	public Iterable<Inmueble> nombreODireccion(String texto) {
		// TODO: Revisar esta funcionalidad (comprobar en la vista "Tasks")
		return repo.findByDescripcionContainingOrDireccionContaining(texto, texto);
	}

	@Override
	public Iterable<Inmueble> buscador(BigDecimal min, BigDecimal max, Tipo tipo, String texto) {
		return repo.findByMinMaxTipoNombreDireccion(min, max, tipo, texto);
	}

}
