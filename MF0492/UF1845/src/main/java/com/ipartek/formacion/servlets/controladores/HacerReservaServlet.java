package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ipartek.formacion.servlets.modelos.Notificacion;
import com.ipartek.formacion.servlets.modelos.Reserva;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hacer-reserva")
public class HacerReservaServlet extends HttpServlet {
	private static final String EMAIL_CAMARERO = "camarero@restaurantapp.com";
	private static final String EMAIL_NOTIFICACIONES = "notificaciones@restaurantapp.com";
	private static final String HACER_RESERVA_JSP = "/WEB-INF/vistas/hacer-reserva.jsp";
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String fechaHora = request.getParameter("fechaHora");
		String numeroPersonas = request.getParameter("numeroPersonas");
		String comentarios = request.getParameter("comentarios");

		Reserva reserva = new Reserva(null, nombre, email, telefono, fechaHora, numeroPersonas, comentarios);

		if (reserva.getErrores().size() > 0) {
			request.setAttribute("alertatexto", "No se ha podido realizar la reserva. Revise los datos.");
			request.setAttribute("alertanivel", "danger");

			request.setAttribute("reserva", reserva);

			request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
			return;
		}

		Globales.DAO_RESERVA.insertar(reserva);

		notificar(reserva);

		request.setAttribute("alertatexto", "Reserva realizada correctamente");
		request.setAttribute("alertanivel", "success");

		request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
	}

	private void notificar(Reserva reserva) throws ServletException {
		String asunto = String.format("%s %s %s", reserva.getNombre(), reserva.getFechaHora(),
				reserva.getNumeroPersonas());
		String texto = reserva.getTelefono() + "\n\n" + reserva.getComentarios();

		Notificacion notificacionCliente = new Notificacion(null, EMAIL_NOTIFICACIONES, reserva.getEmail(), asunto,
				texto);
		enviarNotificacion(notificacionCliente);

		Notificacion notificacionCamarero = new Notificacion(null, EMAIL_NOTIFICACIONES, EMAIL_CAMARERO, asunto, texto);
		enviarNotificacion(notificacionCamarero);
	}

	private void enviarNotificacion(Notificacion notificacion) throws ServletException {
		System.out.println("REMITENTE:    " + notificacion.getRemitente());
		System.out.println("DESTINATARIO: " + notificacion.getDestinatario());
		System.out.println("ASUNTO:       " + notificacion.getAsunto());

		System.out.println();
		System.out.println(notificacion.getTexto());


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
			
			message.setFrom(new InternetAddress(notificacion.getRemitente()));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(notificacion.getDestinatario()));
			message.setSubject(notificacion.getAsunto());
			message.setSentDate(new Date());
			message.setText(notificacion.getTexto());
			
			Transport.send(message);
		} catch (MessagingException e) {
			throw new ServletException("No se ha podido enviar el correo", e);
		}
	}

}
