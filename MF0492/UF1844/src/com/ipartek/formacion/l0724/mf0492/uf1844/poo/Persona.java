package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class Persona {
	// Constantes
	public static final boolean CON_COMA = true;
	// Variables de instancia (privadas)
	private Long id;
	private String nombre;
	private String apellido;
	
	// Source/Generate constructor using Fields...
	public Persona(Long id, String nombre, String apellido) {
		// Llamamos a los setters
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
	}
	
	public Persona(String nombre, String apellido) {
		this(null, nombre, apellido);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		// Usamos null "Anónimo" y null como valores por defecto
		this(null, "Anónimo", null);
	}

	// Source/Generate getters y setters...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id <= 0) {
			throw new RuntimeException("El id debe ser un número mayor o igual que 1");
		}
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			throw new RuntimeException("El nombre debe tener 3 caracteres o más");
		}
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		if(apellido != null && apellido.trim().length() < 3) {
			throw new RuntimeException("El apellido debe tener 3 caracteres o más");
		}
		this.apellido = apellido;
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
}
