package Clases;

public class Titular {

    private Jugador jugador;

    private int id;

    private Posicion posicion;

    public Titular() {
    }

    public Titular(final Posicion p, final Jugador jug) {
        this.posicion = p;
        this.jugador = jug;
    }

    public void setJugador(final Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setPosicion(final Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
