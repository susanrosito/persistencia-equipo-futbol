package Clases;

import java.util.List;

public class Formacion {

	private List<Titular> Titulares;
	private List<Jugador> Suplentes;
	private Equipo equipo;
	
	public Formacion(List<Titular> ts, List<Jugador> ss, Equipo e){
		this.Titulares = ts;
		this.Suplentes = ss;
		this.equipo = e;
	}
	
	public List<Titular> getTitulares() {
		return Titulares;
	}
	public void setTitulares(List<Titular> titulares) {
		Titulares = titulares;
	}
	public List<Jugador> getSuplentes() {
		return Suplentes;
	}
	public void setSuplentes(List<Jugador> suplentes) {
		Suplentes = suplentes;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
