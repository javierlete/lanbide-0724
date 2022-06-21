package com.ipartek.formacion.servlets.modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private LocalDateTime fechaHora;
	private Integer numeroPersonas;
	private String comentarios;
	// private Set<Mesa> mesas = new HashSet<>();
	public Reserva(Long id, String nombre, String email, String telefono, LocalDateTime fechaHora,
			Integer numeroPersonas, String comentarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaHora = fechaHora;
		this.numeroPersonas = numeroPersonas;
		this.comentarios = comentarios;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comentarios, email, fechaHora, id, nombre, numeroPersonas, telefono);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(comentarios, other.comentarios) && Objects.equals(email, other.email)
				&& Objects.equals(fechaHora, other.fechaHora) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroPersonas, other.numeroPersonas)
				&& Objects.equals(telefono, other.telefono);
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", fechaHora=" + fechaHora + ", numeroPersonas=" + numeroPersonas + ", comentarios=" + comentarios
				+ "]";
	}
	
}
