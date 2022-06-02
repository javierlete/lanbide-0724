package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos;

import com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.entidades.Empleado;

// Añadimos a las operaciones básicas de todos los tipos generales de DAO
// las operaciones específicas de un Empleado concreto
// Habrá uno por entidad
public interface DaoEmpleado extends Dao<Empleado> {

}
