package Clases;

import Interfaces.Nombrable;

public class Equipo implements  Nombrable {

	Tecnico tecnico;
	private String nombre;
	


	public Formacion armarFormacion(Equipo e) {
	return this.tecnico.armarFormacion(e);
	}


	
	public String getNombre() {
		
		return this.nombre;
	}



}
