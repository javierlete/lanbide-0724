package com.ipartek.formacion.mf0492.dal;

import com.ipartek.formacion.mf0492.modelos.Area;

public interface DaoArea {
	Iterable<Area> buscarPorCodigoPostal(String codigoPostal);
}
