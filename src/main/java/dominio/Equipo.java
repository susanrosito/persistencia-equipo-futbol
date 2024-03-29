package dominio;

import interfaces.Nombrable;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Nombrable {

    private int id;
    Tecnico tecnico;
    private String nombre;
    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private int cantPartidosDeCopaGanados = 0;

    public Equipo() {
    }

    public Equipo(final String nombre, final Tecnico tec, final List<Jugador> jugadores) {
        this.nombre = nombre;
        this.tecnico = tec;
        this.jugadores = jugadores;

    }

    public void incrementarCantPartidosDeCopaGanados(){
    	this.cantPartidosDeCopaGanados = this.cantPartidosDeCopaGanados + 1;
    }
    
    
    public Formacion armarFormacion() {
        return this.tecnico.armarFormacion(this);
    }
    
    public String toString(){
		return this.nombre;
    }

    @Override
    public String getNombre() {

        return this.nombre;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(final Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(final List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
   
    public void setCantPartidosDeCopaGanados(int cantPartidosDeCopaGanados) {
        this.cantPartidosDeCopaGanados = cantPartidosDeCopaGanados;
    }

    public int getCantPartidosDeCopaGanados() {
        return cantPartidosDeCopaGanados;
    }
}
