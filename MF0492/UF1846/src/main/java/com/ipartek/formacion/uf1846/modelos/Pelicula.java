package com.ipartek.formacion.uf1846.modelos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pelicula {
	private Long id;
	private String titulo;
	private BigDecimal precio;
	
	private Genero genero;
	
	private final Map<String, String> errores = new HashMap<>();

	public Pelicula(String id, String titulo, String precio, String generoId, String generoNombre) {
		this(id, titulo, precio, new Genero(generoId, generoNombre));
	}
	
	public Pelicula(String id, String titulo, String precio, Genero genero) {
		setId(id);
		setTitulo(titulo);
		setPrecio(precio);
		setGenero(genero);
	}
	
	public Pelicula(Long id, String titulo, BigDecimal precio, Genero genero) {
		setId(id);
		setTitulo(titulo);
		setPrecio(precio);
		setGenero(genero);
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().length() == 0) {
			errores.put("titulo", "Se debe introducir un título");
		}
		this.titulo = titulo.trim();
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "El precio debe ser un número");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio no puede ser menor que 0");
		}
		this.precio = precio;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, id, precio, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(precio, other.precio) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", genero=" + genero + ", errores="
				+ errores + "]";
	}
}
