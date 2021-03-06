package com.ipartek.formacion.spring.springmvc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	
	@Email
	private String email;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@NotNull
	@ManyToOne // (fetch = FetchType.EAGER) // Genera demasiadas SELECT: una SELECT por cada Usuario para obtener el Rol de cada uno
	private Rol rol;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
}
