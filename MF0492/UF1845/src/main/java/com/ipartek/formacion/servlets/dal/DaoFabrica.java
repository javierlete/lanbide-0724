package com.ipartek.formacion.servlets.dal;

// El objetivo de esta fábrica es crear objetos de DAOs específicos (memoria, mysql, oracle)
// Tendrá métodos getDaoEntidad()
public class DaoFabrica {
	private DaoUsuario daoUsuario;
	private DaoReserva daoReserva;
	
	public DaoFabrica(String tipoDao) {
		this(tipoDao, null, null, null, null);
	}
	// Esta fábrica concretamente genera sólo un objeto de DAO por cada entidad
	// Con ello está creando el objeto como si fuera un Singleton
	public DaoFabrica(String tipoDao, String url, String user, String pass, String driver) {
		switch(tipoDao) {
		case "memoria":
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			daoReserva = new DaoReservaMemoria();
			break;
		case "mysql":
			daoUsuario = new DaoUsuarioMySql(url, user, pass, driver);
			break;
		default:
			throw new DalException("No conozco ese tipo " + tipoDao);
		}
	}
	
	// Como no se hace un new en cada get, siempre devuelve el mismo objeto
	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
	
	public DaoReserva getDaoReserva() {
		return daoReserva;
	}
}
