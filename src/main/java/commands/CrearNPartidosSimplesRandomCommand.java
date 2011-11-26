package commands;

import homes.EquipoHome;
import homes.PartidoSimpleHome;

import java.util.ArrayList;
import java.util.Random;

import dominio.Equipo;
import dominio.PartidoSimple;

public class CrearNPartidosSimplesRandomCommand implements Runnable{
	int cantPS;
	
	public CrearNPartidosSimplesRandomCommand(int cantPartidos){
		this.cantPS = cantPartidos;
	}

	@Override
	public void run() {
		
		ArrayList<Equipo> equipos = (ArrayList<Equipo>) new EquipoHome().getEquipos();
		Random nroRandom = new Random();
		
		int sizeEquipos = equipos.size()-1;
		System.out.println(sizeEquipos);
		
		while(this.cantPS > 0){
		
			int nroEq1 = nroRandom.nextInt(sizeEquipos);
			int nroEq2 = nroRandom.nextInt(sizeEquipos);
		
			while(nroEq1 == nroEq2){
				nroEq2 = nroRandom.nextInt(sizeEquipos);
			}
		
			Equipo eq1 = equipos.get(nroEq1);
			int g1 = nroRandom.nextInt(6);
			Equipo eq2 = equipos.get(nroEq2);
			int g2 = nroRandom.nextInt(6);
		
			PartidoSimple partSimple = new PartidoSimple(eq1,eq2);
			partSimple.setGolesEquipoA(g1);
			partSimple.setGolesEquipoB(g2);
			
		
			new PartidoSimpleHome().save(partSimple);
			this.cantPS = this. cantPS - 1;
		}
		
	}

}
