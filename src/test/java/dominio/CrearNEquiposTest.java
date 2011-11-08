package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import commands.CrearNEquiposCommands;
import commands.HibernateManager;

public class CrearNEquiposTest extends TestCase {

	private String[] nombresEquipo;
	private String[] nombresTecnico;
	private String[] nombresJugadores;
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

		nombresTecnico = new String[6]; // allocates memory for 10 integers

		nombresTecnico[0] = "Cesar Rema "; // initialize first element
		nombresTecnico[1] = "Migenso Figo "; // initialize second element
		nombresTecnico[2] = "Rodrigo Tapa "; // etc.
		nombresTecnico[3] = "Matsu takanada ";
		nombresTecnico[4] = "Veliztice Dogo ";
		nombresTecnico[5] = "Lucas Martinez ";

		
		nombresJugadores = new String[10]; // allocates memory for 10 integers

		nombresJugadores[0] = "Nicolas "; // initialize first element
		nombresJugadores[1] = "Rodrigo "; // initialize second element
		nombresJugadores[2] = "Carlos "; // etc.
		nombresJugadores[3] = "Leonel ";
		nombresJugadores[4] = "Cristian ";
		nombresJugadores[5] = "Federico ";
		nombresJugadores[6] = "Ronny ";
		nombresJugadores[7] = "Pablo ";
		nombresJugadores[8] = "Raul ";
		nombresJugadores[9] = "Matias ";
		
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
		
		for (int t = 0; t < 5000; t++) {

			Tecnico tecnico = new Tecnico();
			tecnico.setNombre(nombresTecnico[new Random().nextInt(nombresTecnico.length)] + t);
			tecnico.setFormacionStrategyImp(formacion);
			this.tecnicos.add(tecnico);
		}
		
		
		
		for (int j = 0; j < 40000 ; j++) {

			Jugador jugador = new Jugador();
			jugador.setNombre(nombresJugadores[new Random().nextInt(nombresJugadores.length )] + j);
			jugador.setHabilidad(new HabilidadImp(posiciones.get(new Random().nextInt(9)), new Random().nextInt(11)) , 0);
			this.jugadores.add(jugador);

		
	}
}
	public void testApp() throws Exception {

		HibernateManager.instance().runInSession(new CrearNEquiposCommands(5000, nombresEquipo, tecnicos, jugadores ));

	}
}
