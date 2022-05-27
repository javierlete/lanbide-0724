package com.ipartek.formacion.l0724.mf0492.uf1844.poo.interfaces;

import java.util.ArrayList;

public class InterfacesPrueba {

	public static void main(String[] args) {
		ArrayList<Esferico> esfericos = new ArrayList<>();
		
		esfericos.add(new Balon());
		esfericos.add(new Naranja());
		
		for(Esferico e: esfericos) {
			if(e instanceof Comestible) {
				((Comestible)e).comer();
			}
			
			e.rodar();
			
			if(e instanceof Comestible) {
				((Comestible)e).comer();
			}
		}
	}

}
