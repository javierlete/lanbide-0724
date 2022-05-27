package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

import java.util.Objects;

public class Persona {
	// Constantes
	public static final boolean CON_COMA = true;
	
	// Variable estática
	private static int numeroPersonas = 0;
	private static String anonimo = "ANÓNIMO";
	
	// Variables de instancia (privadas)
	private Long id;
	private String nombre;
	private String apellido;
	
	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getApellido());
	}
	
	// Source/Generate constructor using Fields...
	public Persona(Long id, String nombre, String apellido) {
		// Llamamos a los setters
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		
		numeroPersonas++;
	}
	
	public Persona(String nombre, String apellido) {
		this(null, nombre, apellido);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		// Usamos null "Anónimo" y null como valores por defecto
		this(null, anonimo, null);
	}

	// Destructor
	protected void finalize() {
		numeroPersonas--;
	}
	
	// Source/Generate getters y setters...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id <= 0) {
			throw new EntidadesException("El id debe ser un número mayor o igual que 1");
		}
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			throw new EntidadesException("El nombre debe tener 3 caracteres o más");
		}
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		if(apellido != null && apellido.trim().length() < 3) {
			throw new EntidadesException("El apellido debe tener 3 caracteres o más");
		}
		this.apellido = apellido;
	}
	
	public static String getAnonimo() {
		return anonimo;
	}

	public static void setAnonimo(String anonimo) {
		Persona.anonimo = anonimo;
	}
	
	public static int getNumeroPersonas() {
		return numeroPersonas;
	}

	// Métodos de instancia
	public String getNombreCompleto() {
		return String.format("%s %s", nombre, apellido);
	}
	
	public String getNombreCompleto(boolean conComa) {
		if(conComa) {
			return String.format("%2$s, %1$s", nombre, apellido);
		} else {
			return getNombreCompleto();
		}
	}

	

	// Source/Generate hashCode() and equals()
	@Override
	public int hashCode() {
		return Objects.hash(apellido, id, nombre);
	}

	// Necesario para que las comparaciones entre dos Persona's
	// se hagan por contenido y no sólo por que sean la misma
	
	// Source/Generate hashCode() and equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	// Source/Generate toString()...
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
