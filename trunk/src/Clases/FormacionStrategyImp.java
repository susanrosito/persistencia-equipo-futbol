package Clases;

import java.util.ArrayList;
import java.util.List;

import Interfaces.FormacionStrategy;

public class FormacionStrategyImp implements FormacionStrategy {
	private List<Posicion> posiciones;
	
	@Override
	public Formacion armarFormacion(Equipo e) {
	// En realidad voy a copiar la lista del equipo.
		ArrayList<Jugador>	ejugadores = new ArrayList<Jugador>();
	// creo una formacion: 
		Formacion formacionADevolver = new Formacion();
		
	//Recorro para ver quien es el elegido. Para cada posicion cuando se terminen las posiciones.
	// Ya se eligieron a todos los titulares los restantes son suplentes y ect..
		
	// si es asignado ... no lo vuelvo a elegir. lo quito.
		
	// Creo la formacion.... tanto la lista de titulares y suplentes y le paso el equipo.
	
	
	return null;
		
	}

	
	
	

}
