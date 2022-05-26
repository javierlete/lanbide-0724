package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

import java.util.Objects;

public class Empleado extends Persona {
	private String nif;

	// Source/Generate constructor using fields...
	// No uso el de superclass porque sólo me genera los campos del padre, pero no los del hijo
	// Además el resto los genero a mano
	public Empleado(Long id, String nombre, String apellido, String nif) {
		super(id, nombre, apellido);
		setNif(nif);
	}
	
	public Empleado(String nombre, String apellido, String nif) {
		this(null, nombre, apellido, nif);
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nif);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(nif, other.nif);
	}

	// Necesita llamar a los getters de Persona porque no se tiene acceso a los elementos privados desde el hijo
	// Source/Generate toString...
	@Override
	public String toString() {
		return "Empleado [nif=" + nif + ", id=" + getId() + ", nombre=" + getNombre() + ", apellido="
				+ getApellido() + "]";
	}
	
//	@Override
//	public String toString() {
//		return super.toString() + getNif();
//	}
	
	
}
