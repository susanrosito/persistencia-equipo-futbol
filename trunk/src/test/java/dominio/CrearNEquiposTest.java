package dominio;

import interfaces.FormacionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commands.ArmarFormacionCommand;
import commands.CrearNEquiposCommands;
import commands.HibernateManager;

import junit.framework.TestCase;

public class CrearNEquiposTest extends TestCase {

	private String[] nombresEquipo;
	private String[] nombresTecnico;
	private List<Tecnico> tecnicos;
	private List<Jugador> jugadores;
	private FormacionStrategyImp formacion;
	private List<Posicion> posiciones;

	protected void setUp() throws Exception {

		nombresEquipo = new String[10]; // allocates memory for 10 integers

		nombresEquipo[0] = "Boca "; // initialize first element
		nombresEquipo[1] = "River "; // initialize second element
		nombresEquipo[2] = "Racing "; // etc.
		nombresEquipo[3] = "San Lorenzo ";
		nombresEquipo[4] = "Lanus ";
		nombresEquipo[5] = "Gody Cruz ";
		nombresEquipo[6] = "Independientes ";
		nombresEquipo[7] = "Velez ";
		nombresEquipo[8] = "Gimnacia ";
		nombresEquipo[9] = "Estudiantes ";

		nombresTecnico = new String[10]; // allocates memory for 10 integers

		nombresTecnico[0] = "Cesar Rema "; // initialize first element
		nombresTecnico[1] = "Migenso Figo "; // initialize second element
		nombresTecnico[2] = "Rodrigo Tapa "; // etc.
		nombresTecnico[3] = "Matsu takanada ";
		nombresTecnico[4] = "Veliztice Dogo ";
		nombresTecnico[5] = "Lucas Martinez ";

		tecnicos = new ArrayList<Tecnico>();

		jugadores = new ArrayList<Jugador>();
		
		posiciones = new ArrayList<Posicion>();
		
		posiciones.add(Posicion.ARQUERO);
		posiciones.add(Posicion.CENTRAL);
		posiciones.add(Posicion.DELANTERO);
		posiciones.add(Posicion.ENGANCHE);
		posiciones.add(Posicion.LATERAL);
		posiciones.add(Posicion.MEDIA_PUNTA);
		posiciones.add(Posicion.VOLANTE_DEFENSIVO);
		posiciones.add(Posicion.VOLANTE_LATERAL);
	
		formacion = new FormacionStrategyImp(posiciones); 
		
		for (int j = 0; j < 5000; j++) {

			Tecnico tecnico = new Tecnico();
			tecnico.setNombre(nombresTecnico[new Random().nextInt(nombresTecnico.length)] + j);
			tecnico.setFormacionStrategy(formacion);
			this.tecnicos.add(tecnico);
		}
	};

	public void testApp() throws Exception {

		HibernateManager.instance().runInSession(new CrearNEquiposCommands(5000, nombresEquipo, tecnicos ));

	}
}
