package Clases;

import java.util.List;

import Interfaces.Nombrable;


public class Equipo implements  Nombrable {

	
	Tecnico tecnico;
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo (String nombre, Tecnico tec)
	{
		this.nombre=nombre;
		this.tecnico=tec;
	}

	public Formacion armarFormacion() {
	return this.tecnico.armarFormacion(this);
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

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}



}
