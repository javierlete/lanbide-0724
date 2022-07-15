package com.ipartek.formacion.mf0492.modelos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Consulta {
	private Long id;
	private Usuario usuario;
	private LocalDateTime fecha = LocalDateTime.now();
	private String busqueda;
}
