package com.ipartek.formacion.uf1846.modelos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Genero {
	private Long id;
	private String nombre;
	
	private final Map<Long, Pelicula> peliculas = new HashMap<>();
	
	private final Map<String, String> errores = new HashMap<>();

	public Genero(String id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public Genero(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public Long getId() {
		return id;
	}

	private void setId(String id) {
		if(id == null || id.trim().length() == 0) {
			setId((Long)null);
			return;
		}
		
		try {
			setId(Long.parseLong(id));
		} catch (NumberFormatException e) {
			errores.put("id", "El id debe ser un número");
		}
	}
	
	public void setId(Long id) {
		if(id != null && id <= 0) {
			errores.put("id", "Se necesitan ids mayores que 0");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			errores.put("nombre", "Se debe introducir un nombre");
		}
		this.nombre = nombre.trim();
	}

	public void agregarPelicula(Pelicula pelicula) {
		peliculas.put(pelicula.getId(), pelicula);
	}

	public void quitarPelicula(Long id) {
		peliculas.remove(id);
	}
	
	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, peliculas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(peliculas, other.peliculas);
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + ", peliculas=" + peliculas + ", errores=" + errores + "]";
	}
}
