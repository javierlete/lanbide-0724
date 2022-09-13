package com.ipartek.formacion.spring.mf0493.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.repositorios.InmuebleRepository;

@Service
public class InmuebleAdminServiceImpl implements InmuebleAdminService {

	@Autowired
	private InmuebleRepository repo;
	
	@Override
	public Inmueble alta(Inmueble inmueble) {
		return repo.save(inmueble);
	}

	@Override
	public Iterable<Inmueble> listado() {
		return repo.findAll();
	}
}
