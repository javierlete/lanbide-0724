package com.ipartek.formacion.mf0492.filtros;

import java.io.IOException;

import com.ipartek.formacion.mf0492.modelos.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(servletNames = "busqueda")
public class BusquedaFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = -1622544893322907995L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Usuario usuario = (Usuario)((HttpServletRequest)request).getSession().getAttribute("usuario");
		
		if(usuario == null) {
			((HttpServletResponse)response).sendRedirect("login");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
