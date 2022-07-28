package com.ipartek.formacion.spring.springmvc.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "facturas")
@Data
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private LocalDate fecha;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Cliente cliente;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	private Set<Producto> productos;
	
	public BigDecimal getTotal() {
		throw new EntidadesException();
	}
}
