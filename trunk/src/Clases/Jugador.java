package Clases;


import java.util.List;

import Interfaces.Habilidad;
import Interfaces.Nombrable;

public class Jugador implements Nombrable, Habilidad {


	private String nombre;
	private List<HabilidadImp> habilidades;

	public String getNombre() {
		return this.nombre;
	}

	
	public int getValor(Posicion p) {
		return 0;
	}


	public void setHabilidades(List<HabilidadImp> habilidades) {
		this.habilidades = habilidades;
	}


	public List<HabilidadImp> getHabilidades() {
		return habilidades;
	}

	
	


}
