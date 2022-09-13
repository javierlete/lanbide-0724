package com.ipartek.formacion.spring.mf0493.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inmuebles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inmueble {
	public enum Tipo { Alquiler, Venta };
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	private Tipo tipo;
	private BigDecimal precio;
	private String direccion;
}
