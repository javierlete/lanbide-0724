package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

import java.util.HashSet;
import java.util.Set;

public class Espacio {
	// Variable de instancia
	private Long id;
	private String nombre;
	private Set<Persona> personas = new HashSet<>();

	// Constructor de copia
	// Siempre suele ser superficial
	// La colección de personas por ejemplo se comparte entre los
	// dos objetos
	public Espacio(Espacio espacio) {
		setId(espacio.getId());
		setNombre(espacio.getNombre());
		setPersonas(espacio.getPersonas());
	}
	
	public Espacio(String nombre) {
		setNombre(nombre);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	private void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	public void entrar(Persona persona) {
		personas.add(persona);
	}
	
	public void salir(Persona persona) {
		personas.remove(persona);
	}
}
