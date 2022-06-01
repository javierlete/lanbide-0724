package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.presentacion;

import static com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos.DaoEmpleado;
import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos.DaoEmpleadoMemoria;
import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades.Empleado;
import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades.EntidadesException;

public class PresentacionConsola {
	private static final DaoEmpleado DAO = DaoEmpleadoMemoria.getInstancia();

//	private static final Logger LOGGER = Logger.getLogger(PresentacionConsola.class.getName());
	
	public static void main(String[] args) {
//		LOGGER.severe("Se ha iniciado el programa"); // Level.SEVERE
//		LOGGER.log(Level.SEVERE, "Fallo del programa", new RuntimeException("Fallo"));
		
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
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			pl("Gracias por utilizar la aplicación");
			break;
		default:
			errorPl("Por favor, elija una de las opciones existentes");
		}
	}

	private static void mostrarTodos() {
		for (Empleado e : DAO.obtenerTodos()) {
			mostrarLinea(e);
		}
	}

	private static void buscarPorId() {
		long id = pedirLong("Dime el id a buscar");
		Empleado empleado = DAO.obtenerPorId(id);
		mostrarFicha(empleado);
	}

	private static void insertar() {
		Empleado empleado = new Empleado();
		
		boolean repetir = true;
		
		do {
			try {
				empleado.setNombre(pedirString("Nombre"));
				repetir = false;
			} catch (EntidadesException e) {
				pl(e.getMessage());
			} 
		} while (repetir);
		
		empleado.setNif(pedirString("NIF"));
		empleado.setFechaNacimiento(pedirLocalDate("Fecha de nacimiento"));
		empleado.setSueldo(pedirBigDecimal("Sueldo"));

		// Empleado empleado = new Empleado(null, nif, nombre, fechaNacimiento, sueldo);

		DAO.insertar(empleado);
	}

	private static void modificar() {
		Long id = pedirLong("Id");
		String nombre = pedirString("Nombre");
		String nif = pedirString("NIF");
		LocalDate fechaNacimiento = pedirLocalDate("Fecha de nacimiento");
		BigDecimal sueldo = pedirBigDecimal("Sueldo");

		Empleado empleado = new Empleado(id, nif, nombre, fechaNacimiento, sueldo);

		DAO.modificar(empleado);
	}

	private static void borrar() {
		long id = pedirLong("Dime el id a borrar");
		DAO.borrar(id);
	}

	private static void mostrarFicha(Empleado empleado) {
		if(empleado == null) {
			pl("No existe ese empleado");
			return;
		}
		
		pl(empleado);
	}

	private static void mostrarLinea(Empleado empleado) {
		pl(empleado);
	}

//	private static void modificar() {
	// Empleado empleado = pedirDatosEmpleado(true);
	//
	// DAO.modificar(empleado);
	// }
	//
	// private static void insertar() {
	// Empleado empleado = pedirDatosEmpleado(false);
	//
	// DAO.insertar(empleado);
	// }
	//
	// private static Empleado pedirDatosEmpleado(boolean conId) {
	// Long id = null;
	//
	// if(conId) {
	// id = pedirLong("Id");
	// }
	//
	// String nombre = pedirString("Nombre");
	// String nif = pedirString("NIF");
	// LocalDate fechaNacimiento = pedirLocalDate("Fecha de nacimiento");
	// BigDecimal sueldo = pedirBigDecimal("Sueldo");
	//
	// Empleado empleado = new Empleado(id, nif, nombre, fechaNacimiento, sueldo);
	//
	// return empleado;
	// }
}
