package com.ipartek.formacion.spring.springmvc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(unique = true)
	@Size(max = 100)
	private String nick;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	private String password;
	
	private String nombre;
	private String email;
	
	@NotNull
	private String rol = "USUARIO";
}
