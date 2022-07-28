package com.ipartek.formacion.spring.springmvc.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springmvc.dtos.UsuarioRol;
import com.ipartek.formacion.spring.springmvc.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	@Query("select u from Usuario u join fetch u.rol where nick = :nick")
	Usuario findByNick(String nick);
	
	@Query("select u from Usuario u join fetch u.rol")
	Set<Usuario> obtenerTodosConRol();
	
	@Query("select new com.ipartek.formacion.spring.springmvc.dtos.UsuarioRol(u.id, u.nick, u.password, r.nombre) from Usuario u join u.rol r where u.nick = :nick")
	UsuarioRol obtenerUsuarioRol(String nick);
}
