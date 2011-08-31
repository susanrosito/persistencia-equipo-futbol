package Clases;


import java.util.List;
import java.util.Map;

import Interfaces.Habilidad;
import Interfaces.Nombrable;

public class Jugador implements Nombrable, Habilidad {
	private String nombre;
	private List<HabilidadImp> habilidades;

	public Jugador(String nomb, List<HabilidadImp> habs){
		this.nombre = nomb;
		this.habilidades = habs;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}

	
	public int getValor(Posicion p) {
		int valor = 0;
		int maxVal = 0;
		for(HabilidadImp hab: this.getHabilidades()){
			valor = hab.getValor(p);
			if(valor > maxVal){
				maxVal = valor;
			}
		}
		return maxVal;
	}
	
	public void setHabilidad(HabilidadImp hab, int val){
		//falta crear habilidad en caso de no encontrarla
		for(HabilidadImp habAc:this.getHabilidades()){
			if(habAc.getPosicion() == hab.getPosicion()){
				habAc.setValor(hab.getValor());
				break;
			}
		}
	}

	public void setHabilidades(List<HabilidadImp> habilidades) {
		this.habilidades = habilidades;
	}


	public List<HabilidadImp> getHabilidades() {
		return habilidades;
	}

}
