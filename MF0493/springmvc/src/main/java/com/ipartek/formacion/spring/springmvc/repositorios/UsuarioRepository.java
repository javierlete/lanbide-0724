package com.ipartek.formacion.spring.springmvc.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springmvc.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
