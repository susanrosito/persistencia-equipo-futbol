package Clases;

public class Titular {

	private Jugador jugador;
	private Posicion posicion;
	
	
	public Titular(Posicion p, Jugador jug){
		this.posicion = p;
		this.jugador = jug;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	
	
}
