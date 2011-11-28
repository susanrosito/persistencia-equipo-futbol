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

    @Override
    protected void setUp() throws Exception {

        this.nombresEquipo = new String[10]; // allocates memory for 10 integers

        this.nombresEquipo[0] = "Boca "; // initialize first element
        this.nombresEquipo[1] = "River "; // initialize second element
        this.nombresEquipo[2] = "Racing "; // etc.
        this.nombresEquipo[3] = "San Lorenzo ";
        this.nombresEquipo[4] = "Lanus ";
        this.nombresEquipo[5] = "Gody Cruz ";
        this.nombresEquipo[6] = "Independientes ";
        this.nombresEquipo[7] = "Velez ";
        this.nombresEquipo[8] = "Gimnacia ";
        this.nombresEquipo[9] = "Estudiantes ";

        this.nombresTecnico = new String[6]; // allocates memory for 10 integers

        this.nombresTecnico[0] = "Cesar Rema "; // initialize first element
        this.nombresTecnico[1] = "Migenso Figo "; // initialize second element
        this.nombresTecnico[2] = "Rodrigo Tapa "; // etc.
        this.nombresTecnico[3] = "Matsu takanada ";
        this.nombresTecnico[4] = "Veliztice Dogo ";
        this.nombresTecnico[5] = "Lucas Martinez ";

        this.nombresJugadores = new String[10]; // allocates memory for 10 integers

        this.nombresJugadores[0] = "Nicolas "; // initialize first element
        this.nombresJugadores[1] = "Rodrigo "; // initialize second element
        this.nombresJugadores[2] = "Carlos "; // etc.
        this.nombresJugadores[3] = "Leonel ";
        this.nombresJugadores[4] = "Cristian ";
        this.nombresJugadores[5] = "Federico ";
        this.nombresJugadores[6] = "Ronny ";
        this.nombresJugadores[7] = "Pablo ";
        this.nombresJugadores[8] = "Raul ";
        this.nombresJugadores[9] = "Matias ";

        this.tecnicos = new ArrayList<Tecnico>();

        this.jugadores = new ArrayList<Jugador>();

        this.posiciones = new ArrayList<Posicion>();

        this.posiciones.add(Posicion.ARQUERO);
        this.posiciones.add(Posicion.CENTRAL);
        this.posiciones.add(Posicion.DELANTERO);
        this.posiciones.add(Posicion.ENGANCHE);
        this.posiciones.add(Posicion.LATERAL);
        this.posiciones.add(Posicion.MEDIA_PUNTA);
        this.posiciones.add(Posicion.VOLANTE_DEFENSIVO);
        this.posiciones.add(Posicion.VOLANTE_LATERAL);

        this.formacion = new FormacionStrategyImp(this.posiciones);

        for (int t = 0; t < 5000; t++) {

            Tecnico tecnico = new Tecnico();
            tecnico.setNombre(this.nombresTecnico[new Random().nextInt(this.nombresTecnico.length)] + t);
            tecnico.setFormacionStrategy(this.formacion);
            this.tecnicos.add(tecnico);
        }

        for (int j = 0; j < 40000; j++) {

            Jugador jugador = new Jugador();
            jugador.setNombre(this.nombresJugadores[new Random().nextInt(this.nombresJugadores.length)] + j);
            jugador.setHabilidad(
                    new HabilidadImp(this.posiciones.get(new Random().nextInt(8)), new Random().nextInt(10)), 0);
            this.jugadores.add(jugador);

        }
    }

    public void testApp() throws Exception {
    	
    	long ti = System.currentTimeMillis();
    	
        HibernateManager.instance().runInSession(
                new CrearNEquiposCommands(5, this.nombresEquipo, this.tecnicos, this.jugadores));
        
        long tf = System.currentTimeMillis() - ti;
        System.out.println("La ejecución ha tardado: "+ tf + " milisegundos");
    }
}
