package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas;

public class Validaciones {
	private static final String letrasNif = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static boolean validarNif(String nif) {
		if(nif == null) {
			return false;
		}
		
		if(!nif.matches("^[XYZ\\d]\\d{7}[" + letrasNif + "]$")) {
			return false;
		}
		
		String digitos = nif.substring(0, 8).replace('X', '0').replace('Y', '1').replace('Z', '2');
		char letra = nif.charAt(8);
		
		int numero = Integer.parseInt(digitos);
		
		return letrasNif.charAt(numero % 23) == letra;
	}
}
