package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades.Empleado;

// Implementación concreta de las operaciones de un Empleado
// basada en un almacenamiento en memoria
// "Como si fuera un driver del DAO"
public class DaoEmpleadoMemoria implements DaoEmpleado {

	private static final TreeMap<Long, Empleado> empleados = new TreeMap<>();

	static {
		empleados.put(1L, new Empleado(1L, "12345678Z", "Javier", LocalDate.of(2000, 1, 2), new BigDecimal("12345")));
		empleados.put(2L, new Empleado(2L, "12345678Z", "Nombre2", LocalDate.of(2001, 1, 2), new BigDecimal("22345")));
		empleados.put(3L, new Empleado(3L, "12345678Z", "Nombre3", LocalDate.of(2002, 1, 2), new BigDecimal("32345")));
	}

	// SINGLETON
	//
	// Vamos a hacer que sólo se pueda crear UN (single) objeto DaoEmpleadoMemoria
	// porque no tiene sentido crear varios objetos que hacen exactamente lo mismo
	// Sólo gastarían más memoria
	
	// Al hacer el constructor por defecto privado, ya cerramos la posibilidad de
	// que ningún programa pueda hacer un new de esta clase
	private DaoEmpleadoMemoria() {
	}

	// Creamos UNA sola instancia de este objeto dentro de esta clase
	private static final DaoEmpleadoMemoria INSTANCIA = new DaoEmpleadoMemoria();

	// Damos acceso a recuperar la instancia desde fuera desde un método estático
	// ya que no se puede acceder a otros sin tener previamente la propia instancia
	public static DaoEmpleadoMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Empleado> obtenerTodos() {
		return empleados.values();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return empleados.get(id);
	}

	@Override
	public void insertar(Empleado empleado) {
		Long id = empleados.size() > 0 ? empleados.lastKey() + 1L : 1L;
		empleado.setId(id);
		empleados.put(empleado.getId(), empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		empleados.put(empleado.getId(), empleado);
	}

	@Override
	public void borrar(Long id) {
		empleados.remove(id);
	}

}
