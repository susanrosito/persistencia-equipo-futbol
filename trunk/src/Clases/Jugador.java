package Clases;


import java.util.List;
import java.util.Map;

import Interfaces.Habilidad;
import Interfaces.Nombrable;

public class Jugador implements Nombrable, Habilidad {


	private String nombre;
	private List<HabilidadImp> habilidades;

	public String getNombre() {
		return this.nombre;
	}

	
	public int getValor(Posicion p) {
		HabilidadImp habilidad = null;
		for(HabilidadImp hab: this.getHabilidades()){
			habilidad = hab;
			if(hab.getPosicion() == p){
				break;
			}
		}
		return habilidad.getValor(p);
	}


	public void setHabilidades(List<HabilidadImp> habilidades) {
		this.habilidades = habilidades;
	}


	public List<HabilidadImp> getHabilidades() {
		return habilidades;
	}

	
	


}
