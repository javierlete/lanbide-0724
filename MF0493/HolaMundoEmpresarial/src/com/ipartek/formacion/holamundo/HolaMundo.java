package com.ipartek.formacion.holamundo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HolaMundo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// retrieve configured instance
		Salida s = context.getBean("salida", Salida.class);
		Proveedor p = context.getBean("proveedor", Proveedor.class);
		
		s.mostrar(p.getMensaje());
	}

}
