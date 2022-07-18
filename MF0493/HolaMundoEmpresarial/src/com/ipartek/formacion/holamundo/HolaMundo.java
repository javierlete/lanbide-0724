package com.ipartek.formacion.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// Busca por todas las clases y las que están marcadas como
// @Component las instancias en Singleton y las guardas
@ComponentScan
public class HolaMundo {
	// Busca entre todas las clases instanciadas si tienes una
	// que sea "instanceof" Salida
	@Autowired
	private Salida s;
	
	@Autowired
	private Proveedor p;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HolaMundo.class);
	    HolaMundo holaMundo = ctx.getBean(HolaMundo.class);
	    holaMundo.inicio();
	}

	private void inicio() {
		s.mostrar(p.getMensaje());
	}
	

}
