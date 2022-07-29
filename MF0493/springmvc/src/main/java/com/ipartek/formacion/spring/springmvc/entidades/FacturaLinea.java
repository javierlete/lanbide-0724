package com.ipartek.formacion.spring.springmvc.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "factura_lineas")
@Data
public class FacturaLinea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Factura factura;
	
	@NotNull
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Producto producto;
	
	@NotNull
	@Size(min = 1)
	private Integer cantidad = 1;
	
	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}
