package com.ipartek.formacion.spring.springmvc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(columnDefinition = "CHAR(9)")
	@Size(min = 9, max = 9)
	private String nif;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@NotNull
	@OneToOne(mappedBy = "cliente")
	private Usuario usuario;
}
