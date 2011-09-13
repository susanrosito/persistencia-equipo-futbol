package Clases;

import java.util.List;

import Interfaces.Nombrable;

public class Equipo implements Nombrable {

    private int id;

    Tecnico tecnico;

    private String nombre;

    private List<Jugador> jugadores;

    public Equipo(final String nombre, final Tecnico tec, final List<Jugador> jugadores) {
        this.nombre = nombre;
        this.tecnico = tec;
        this.jugadores = jugadores;
    }

    public Formacion armarFormacion() {
        return this.tecnico.armarFormacion(this);
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

}
