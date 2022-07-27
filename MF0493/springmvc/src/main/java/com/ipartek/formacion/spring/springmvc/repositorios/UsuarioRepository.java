package com.ipartek.formacion.spring.springmvc.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springmvc.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	@Query("select u from Usuario u join fetch u.rol")
	Set<Usuario> obtenerTodosConRol();
}
