package com.ipartek.formacion.spring.springmvc.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "facturas")
@Data
public class Factura {
	private static final BigDecimal IVA = new BigDecimal("0.21");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String numero;
	
	@NotNull
	private LocalDate fecha;
	
	@NotNull
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Cliente cliente;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "factura")
	private Set<FacturaLinea> lineas;
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(FacturaLinea linea: lineas) {
			total = total.add(linea.getTotal());
		}
		
		return total;
	}
	
	public BigDecimal getIva() {
		return getTotal().multiply(IVA);
	}
	
	public BigDecimal getTotalConIva() {
		return getTotal().add(getIva());
	}
}
