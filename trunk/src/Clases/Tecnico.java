package Clases;

import Interfaces.FormacionStrategy;
import Interfaces.Nombrable;

public class Tecnico implements FormacionStrategy,  Nombrable {


	private String nombre;

	public String getNombre() {
		return this.nombre;
	}

	
	public Formacion armarFormacion(Equipo e) {
		// TODO Auto-generated method stub
		return null;
	}

}
