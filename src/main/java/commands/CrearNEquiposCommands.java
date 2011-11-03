package commands;

import homes.EquipoHome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dominio.Equipo;
import dominio.Jugador;
import dominio.Tecnico;

public class CrearNEquiposCommands implements Runnable {

	private int cantEquipos;
	private List<Tecnico> tecnicos;
	private String[] nombreE;
	private List<Jugador> jugadores;
	public CrearNEquiposCommands(int cantEquipos, String[] nombreEquipo,
			List<Tecnico> tecnicos, List<Jugador> jugadores) {

		this.cantEquipos = cantEquipos;
		this.nombreE = nombreEquipo;
		this.tecnicos = tecnicos;
		this.jugadores = jugadores;
	}

	@Override
	public void run() {

		List<Equipo> misNequipos = new ArrayList<Equipo>(); 
		
		for (int i = 0; i < this.cantEquipos; i++) {
			Equipo equipo = new Equipo();
			equipo.setNombre(nombreE[new Random().nextInt(nombreE.length)]);
			equipo.setTecnico(tecnicos.get(i));
			equipo.getJugadores().add(this.jugadores.get(this.jugadores.size()));
			misNequipos.add(equipo);

		}
		new EquipoHome().setNEquipos(misNequipos);
	}

}
