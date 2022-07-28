package com.ipartek.formacion.spring.springmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UsuarioRol {
	private Long id;
	private String nick;
	private String password;
	private String rol;
}
