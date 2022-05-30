package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado {
	// 1. Variables de instancia (privadas)
	private Long id;
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private BigDecimal sueldo;

	// 3. Constructor "mayor"
	public Empleado(Long id, String nif, String nombre, LocalDate fechaNacimiento, BigDecimal sueldo) {
		// 4. Cambiar por setters
		setId(id);
		setNif(nif);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
		setSueldo(sueldo);
	}
	
	// 2. Getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	// 5. hashCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nif, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sueldo, other.sueldo);
	}

	// 6. toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", sueldo=" + sueldo + "]";
	}
	
	
}
