package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Cerebro de la aplicación
// Recoge la información de las peticiones
// Crea objetos del MODELO
// Llama a la lógica de negocio
// En el caso de no existir, llamará directamente al DAO

@WebServlet("/admin/reservas")
public class ReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
// Empaqueta datos para la siguiente vista
		request.setAttribute("reservas", Globales.DAO_RESERVA.obtenerTodos());
// Redirecciona a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
