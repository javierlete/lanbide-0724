package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas.Validaciones;

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
		if (id != null && id < 0) {
			// Lanzamos la excepción personalizada que hemos creado para la
			// capa en la que nos encontramos (entidades)
			throw new EntidadesException("El id debe ser mayor o igual que 0");
		}
		
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		if (!Validaciones.validarNif(nif)) {
			throw new EntidadesException("El NIF introducido debe ser válido");
		}
		
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 2) {
			throw new EntidadesException("El nombre debe estar rellenado y debe tener como mínimo dos caracteres");
		}
		
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now().minusYears(18))
				|| fechaNacimiento.isBefore(LocalDate.of(1900, 1, 1))) {
			throw new EntidadesException("La fecha de nacimiento debe estar comprendida entre 1900 y la fecha actual");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		if(sueldo == null || sueldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new EntidadesException("El sueldo debe ser mayor o igual que 0");
		}
		
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
