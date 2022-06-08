package com.ipartek.formacion.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Todo llegará como Strings
		// Los parámetros llegarán a través de la URL como
		// http://localhost:8081/uf1845/hola?nombre=Javier
		String nombre = request.getParameter("nombre");
		
		// Si no se ha recibido el parámetro
		if(nombre == null) {
			nombre = "a todos";
		}
		
		response.setContentType("text/plain");
		response.getWriter().println("Hola " + nombre);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
