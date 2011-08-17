package Clases;

import Interfaces.Habilidad;

public class HabilidadImp implements Habilidad {

	Posicion posicion;
	int valor;

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

		return this.valor;
	}

}
