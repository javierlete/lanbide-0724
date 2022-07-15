package com.ipartek.formacion.mf0492.modelos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Area {
	private Long id;
	private String municipio;
	private String codigoPostal;
}
