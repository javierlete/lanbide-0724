package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.presentacion;

import static com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas.Consola.errorPl;
import static com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas.Consola.pedirInt;
import static com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas.Consola.pl;

import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos.DaoEmpleado;
import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos.DaoEmpleadoMemoria;
import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades.Empleado;

public class PresentacionConsola {
	private static final DaoEmpleado DAO = DaoEmpleadoMemoria.getInstancia();
	
	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	private static void mostrarMenu() {
		pl("1. Mostrar todos");
		pl("2. Buscar por Id");
		pl("3. Insertar");
		pl("4. Modificar");
		pl("5. Borrar");
		pl("0. Salir");
	}

	private static int pedirOpcion() {
		return pedirInt("Selecciona una de las opciones del menú");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			mostrarTodos();
			break;
		case 2:
			pl("Buscar por id");
			break;
		case 3:
			pl("Insertar");
			break;
		case 4:
			pl("Modificar");
			break;
		case 5:
			pl("Borrar");
			break;
		case 0:
			pl("Gracias por utilizar la aplicación");
			break;
		default:
			errorPl("Por favor, elija una de las opciones existentes");
		}
	}

	private static void mostrarTodos() {
		for(Empleado e: DAO.obtenerTodos()) {
			mostrarLinea(e);
		}
	}

	private static void mostrarLinea(Empleado e) {
		pl(e);
	}
}
