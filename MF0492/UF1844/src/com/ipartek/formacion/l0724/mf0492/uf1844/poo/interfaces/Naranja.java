package com.ipartek.formacion.l0724.mf0492.uf1844.poo.interfaces;

public class Naranja extends Fruto implements Esferico, Comestible {

	private boolean sucia = false;
	
	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		sucia = true;
	}

	@Override
	public void comer() {
		if(sucia) {
			System.out.println("¡Puaj! qué asco");
		} else {
			System.out.println("¡Qué rica!");
		}
	}
	
}
