package com.ipartek.formacion.spring.springmvc.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class Producto {
	@Min(1)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 45)
	private String nombre;
	
	@NotNull
	@DecimalMin("0")
	private BigDecimal precio;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Future
	private LocalDate fechaCaducidad;
	
	@Min(0)
	private Integer stock;
}