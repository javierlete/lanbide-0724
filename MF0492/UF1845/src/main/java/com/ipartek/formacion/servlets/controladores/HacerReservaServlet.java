package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import com.ipartek.formacion.servlets.modelos.Reserva;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hacer-reserva")
public class HacerReservaServlet extends HttpServlet {
	private static final String HACER_RESERVA_JSP = "/WEB-INF/vistas/hacer-reserva.jsp";
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String fechaHora = request.getParameter("fechaHora");
		String numeroPersonas = request.getParameter("numeroPersonas");
		String comentarios = request.getParameter("comentarios");
		
		Reserva reserva = new Reserva(null, nombre, email, telefono, LocalDateTime.parse(fechaHora), Integer.parseInt(numeroPersonas), comentarios);
		
		if(reserva.getErrores().size() > 0) {
			request.setAttribute("alertatexto", "No se ha podido realizar la reserva. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			
			request.setAttribute("reserva", reserva);
			
			request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
			return;
		}
		
		Globales.DAO_RESERVA.insertar(reserva);
		
		request.setAttribute("alertatexto", "Reserva realizada correctamente");
		request.setAttribute("alertanivel", "success");
		
		request.getRequestDispatcher(HACER_RESERVA_JSP).forward(request, response);
	}

}
