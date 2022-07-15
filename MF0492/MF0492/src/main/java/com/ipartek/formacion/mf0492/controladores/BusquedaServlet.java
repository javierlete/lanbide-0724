package com.ipartek.formacion.mf0492.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import com.ipartek.formacion.mf0492.modelos.Consulta;
import com.ipartek.formacion.mf0492.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "busqueda", urlPatterns = "/busqueda")
public class BusquedaServlet extends HttpServlet {
	private static final String BUSQUEDA_JSP = Globales.VISTAS + "/busqueda.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(BUSQUEDA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoPostal = request.getParameter("codigo-postal");
		
		Consulta consulta = Consulta.builder()
				.fecha(LocalDateTime.now())
				.usuario((Usuario)request.getSession().getAttribute("usuario"))
				.busqueda(codigoPostal)
				.build();
				
		Globales.DAO_CONSULTA.insertar(consulta);
		
		request.setAttribute("areas",  Globales.DAO_AREA.buscarPorCodigoPostal(codigoPostal));
		request.getRequestDispatcher(BUSQUEDA_JSP).forward(request, response);
	}
}
