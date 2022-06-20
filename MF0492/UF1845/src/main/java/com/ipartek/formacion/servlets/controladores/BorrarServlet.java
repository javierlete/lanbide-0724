package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Globales.DAO.borrar(Long.parseLong(id));
		
		request.setAttribute("alertatexto", "Se ha borrado el registro " + id + " correctamente");
		request.setAttribute("alertanivel", "success");
		
//		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
		request.getRequestDispatcher("/admin/usuarios").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
