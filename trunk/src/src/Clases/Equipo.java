package Clases;

import Interfaces.FormacionStrategy;
import Interfaces.Nombrable;

public class Equipo implements FormacionStrategy , Nombrable {

	Tecnico tecnico;
	private String nombre;


	public Formacion armarFormacion(Equipo e) {
	return this.tecnico.armarFormacion(e);
	}


	
	public String getNombre() {
		
		return this.nombre;
	}
	
}
