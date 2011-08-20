package Clases;

import Interfaces.Habilidad;

public class HabilidadImp implements Habilidad {

	Posicion posicion;
	int valor;

	public HabilidadImp(Posicion p, int val){
		this.posicion = p;
		this.valor = val;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor(Posicion p) {

		if(p == this.getPosicion()){
			return this.valor;
		}
		else{return 0;}
	}

}
