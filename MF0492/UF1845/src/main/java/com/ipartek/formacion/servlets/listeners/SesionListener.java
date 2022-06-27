package com.ipartek.formacion.servlets.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		
		// Aunque aquí lleguen varios Thread
		synchronized (this) { // sobre este objeto (SesionListener)
			//Dentro de este bloque sólo se admite uno cada vez
			Long contador = (Long)application.getAttribute("contador");
			
			if(contador == null) {
				contador = 0L;
			}
			
			contador++;
			
			application.setAttribute("contador", contador);
		}
		// Y después vuelve a permitirse varios threads a la vez
	}
}
