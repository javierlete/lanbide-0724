package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

// Utilizamos RuntimeException en lugar de Exception a secas
// para que la propagación lleve un throws implícito en lugar
// de tener que especificarla de forma explícita
public class EntidadesException extends RuntimeException {
	// Generate serialVersionUID
	private static final long serialVersionUID = 8024761012693063989L;
	
	// Generate constructors from Superclass
	public EntidadesException() {
		super();
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadesException(String message) {
		super(message);
	}

	public EntidadesException(Throwable cause) {
		super(cause);
	}

	
}
