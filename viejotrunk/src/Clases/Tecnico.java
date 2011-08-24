package Clases;

import Interfaces.FormacionStrategy;
import Interfaces.Nombrable;

public class Tecnico implements Nombrable {


	private String nombre;
	private FormacionStrategy formacionStrategy;

	public String getNombre() {
		return this.nombre;
	}

	
	public Formacion armarFormacion(Equipo e) {
		return this.formacionStrategy.armarFormacion(e);
	}

}
