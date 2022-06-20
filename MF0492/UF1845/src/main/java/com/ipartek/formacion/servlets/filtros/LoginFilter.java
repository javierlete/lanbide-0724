package com.ipartek.formacion.servlets.filtros;

import java.io.IOException;

import com.ipartek.formacion.servlets.modelos.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class LoginFilter extends HttpFilter {

	private static final long serialVersionUID = 4199744105791952282L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		// session.setMaxInactiveInterval(0); // Tiempo en segundos de inactividad para cerrar sesión 
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null) {
			httpRequest.setAttribute("alertatexto", "Debes estar logueado para acceder a la parte de administración");
			httpRequest.setAttribute("alertanivel", "danger");
			httpRequest.getRequestDispatcher("/login").forward(httpRequest, httpResponse);
			return;
		}

		chain.doFilter(request, response);
	}

}
