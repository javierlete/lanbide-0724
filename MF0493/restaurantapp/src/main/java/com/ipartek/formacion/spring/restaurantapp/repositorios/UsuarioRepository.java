package com.ipartek.formacion.spring.restaurantapp.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.restaurantapp.entidades.Usuario;

@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	
}
