package com.ipartek.formacion.servlets.modelos;

import java.util.Date;
import java.util.Objects;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

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
	
	public void enviar() {
		System.out.println("REMITENTE:    " + getRemitente());
		System.out.println("DESTINATARIO: " + getDestinatario());
		System.out.println("ASUNTO:       " + getAsunto());

		System.out.println();
		System.out.println(getTexto());


		try {
			Properties props = new Properties();
			
			// Configuramos para utilizar nuestro propio ordenador como enviador de correos electrónicos
			// Usamos FakeSMTP https://github.com/gessnerfl/fake-smtp-server
			// Para ver los mensajes enviados, utilizar http://localhost:5080
			
			// Para ejemplo de envío con GMail https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.port", 5025);
			
			Session session = Session.getInstance(props, null);

			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(getRemitente()));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(getDestinatario()));
			message.setSubject(getAsunto());
			message.setSentDate(new Date());
			message.setText(getTexto());
			
			Transport.send(message);
		} catch (MessagingException e) {
			throw new ModelosException("No se ha podido enviar el correo", e);
		}
	}

}
