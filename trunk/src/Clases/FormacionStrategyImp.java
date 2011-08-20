package Clases;

import java.util.ArrayList;
import java.util.List;
import Interfaces.FormacionStrategy;

public class FormacionStrategyImp implements FormacionStrategy {
	private List<Posicion> posiciones;
	
	@Override
	public Formacion armarFormacion(Equipo e) {
	// En realidad voy a copiar la lista del equipo.
		ArrayList<Jugador>	jugadores = new ArrayList<Jugador>();
	// creo una formacion: 
		Formacion formacionADevolver = new Formacion();
		
	//Recorro para ver quien es el elegido. Para cada posicion cuando se terminen las posiciones.
	// Ya se eligieron a todos los titulares los restantes son suplentes y ect..
		// puedo hacerlo en subTareas // elejir los mejores.
		Titular jugadorActual;
		for (int i = 0; i < this.getPosiciones().size(); i++) {
			
			Posicion posicionActual = this.getPosiciones().get(i);
			jugadorActual = this.buscarMJugador(jugadores, posicionActual);
			formacionADevolver.getTitulares().add(jugadorActual);
			
		}
			formacionADevolver.getSuplentes().addAll(jugadores);
			formacionADevolver.setEquipo(e);
	// Creo la formacion.... tanto la lista de titulares y suplentes y le paso el equipo.
	
	
	return formacionADevolver;
		
	}
	
	public Titular buscarMJugador(ArrayList<Jugador> ju , Posicion p){
		int mayor = 0;
		int valor;
		int posicion;
		Jugador jugadorElegido;
		for (int i = 0; i < ju.size(); i++) {
			Jugador jugador = ju.get(i);
			valor = jugador.getValor(p);
			if (valor > mayor) {
				mayor = valor;
				jugadorElegido = jugador;
			    posicion = i;
			}
		}
		ju.remove(posicion);
		// Lo que falta es que titular tenga un constructor que reciba una posicion y un jugador	
		return new Titular(p ,jugadorElegido);
	}

	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}
	

}
