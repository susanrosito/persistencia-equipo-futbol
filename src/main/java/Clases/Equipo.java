package Clases;

import Interfaces.Nombrable;

public class Equipo implements  Nombrable {

	
	Tecnico tecnico;
	private String nombre;
	
	public Equipo (String nombre, Tecnico tec)
	{
		this.nombre=nombre;
		this.tecnico=tec;
	}

	public Formacion armarFormacion(Equipo e) {
	return this.tecnico.armarFormacion(e);
	}


	
	public String getNombre() {
		
		return this.nombre;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
