package com.ipartek.formacion.servlets.modelos;

import java.util.Objects;

public class Notificacion {
	private Long id;
	private String remitente, destinatario, asunto, texto;
	public Notificacion(Long id, String remitente, String destinatario, String asunto, String texto) {
		super();
		this.id = id;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.texto = texto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(asunto, destinatario, id, remitente, texto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacion other = (Notificacion) obj;
		return Objects.equals(asunto, other.asunto) && Objects.equals(destinatario, other.destinatario)
				&& Objects.equals(id, other.id) && Objects.equals(remitente, other.remitente)
				&& Objects.equals(texto, other.texto);
	}
	@Override
	public String toString() {
		return "Notificacion [id=" + id + ", remitente=" + remitente + ", destinatario=" + destinatario + ", asunto="
				+ asunto + ", texto=" + texto + "]";
	}
	
	
}
