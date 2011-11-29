package commands;

import homes.EquipoHome;
import homes.PartidoDeCopaHome;

import java.util.ArrayList;
import java.util.Random;

import dominio.Equipo;
import dominio.PartidoDeCopa;

public class CrearNPartidosDeCopaRandomCommand implements Runnable{
	
	int cantPC;
	
	public CrearNPartidosDeCopaRandomCommand(int cantPartidos){
		this.cantPC = cantPartidos;
	}

	@Override
	public void run() {
		
		ArrayList<Equipo> equipos = (ArrayList<Equipo>) new EquipoHome().getEquipos();
		Random nroRandom = new Random();
		
		int sizeEquipos = equipos.size()-1;
		System.out.println(sizeEquipos);
		
		while(this.cantPC > 0){
		
			int nroEq1 = nroRandom.nextInt(sizeEquipos);
			int nroEq2 = nroRandom.nextInt(sizeEquipos);
		
			while(nroEq1 == nroEq2){
				nroEq2 = nroRandom.nextInt(sizeEquipos);
			}
		
			Equipo eq1 = equipos.get(nroEq1);
			int gP1e1 = nroRandom.nextInt(6);
			int gP2e1 = nroRandom.nextInt(6);
			int penalesE1 = nroRandom.nextInt(5);
			Equipo eq2 = equipos.get(nroEq2);
			int gP1e2 = nroRandom.nextInt(6);
			int gP2e2 = nroRandom.nextInt(6);
			int penalesE2 = nroRandom.nextInt(5);
			
			while(penalesE1 == penalesE2){
				penalesE2 = nroRandom.nextInt(5);
			}
		
			PartidoDeCopa partCopa = new PartidoDeCopa(eq1,eq2);
			partCopa.getPrimerPartido().setGolesEquipoA(gP1e1);
			partCopa.getPrimerPartido().setGolesEquipoB(gP1e2);
			partCopa.getSegundoPartido().setGolesEquipoA(gP2e1);
			partCopa.getSegundoPartido().setGolesEquipoB(gP2e2);
			partCopa.setPenalesConvertidosEquipoA(penalesE1);
			partCopa.setPenalesConvertidosEquipoB(penalesE2);
			partCopa.getGanadorP().incrementarCantPartidosDeCopaGanados();
			
			new PartidoDeCopaHome().save(partCopa);
			this.cantPC = this. cantPC - 1;
		}
		
	}


}
