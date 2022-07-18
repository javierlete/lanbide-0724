package com.ipartek.formacion.spring.springmvc.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaCaducidad;
	private Integer	stock;
}