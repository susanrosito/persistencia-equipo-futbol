package commands;

import java.util.List;
import java.util.Random;

import dominio.Equipo;
import dominio.Tecnico;

public class CrearNEquiposCommands implements Runnable {

		private int cantEquipos; 
		private List<Tecnico> tecnicos;
		private String[] nombreE;
	public CrearNEquiposCommands(int cantEquipos, String[] nombreEquipo, List<Tecnico> tecnicos) {
		
		this.cantEquipos = cantEquipos;
		this.nombreE = nombreEquipo;
		this.tecnicos = tecnicos;
	}
	
	
	
	@Override
	public void run() {
	
		for (int i = 0; i < this.cantEquipos; i++) {
			Equipo equipo = new Equipo();
			equipo.setNombre(nombreE[new Random().nextInt(nombreE.length)]);
			equipo.setTecnico(tecnicos.get(i));
					
		}
		
	}

}
