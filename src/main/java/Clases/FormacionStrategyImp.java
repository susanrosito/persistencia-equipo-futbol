package Clases;

import java.util.ArrayList;
import java.util.List;
import Interfaces.FormacionStrategy;

public class FormacionStrategyImp implements FormacionStrategy {
    private List<Posicion> posiciones;

    public FormacionStrategyImp(ArrayList<Posicion> posiciones) {

        this.posiciones = posiciones;

    }

    @Override
    public Formacion armarFormacion(Equipo e) {

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Formacion formacion = new Formacion();
        this.buscarLosTitulares(formacion, jugadores);
        formacion.getSuplentes().addAll(jugadores);
        formacion.setEquipo(e);

        return formacion;

    }

    /**
     * PRECONDICION: Encuentra por lo menos un jugador mayor a los demas. PROPOSITO: Busca al mejor jugador para la
     * posicion que le pasan por parametro.
     * 
     * @param Jugador
     *            jugadores
     * @param P
     *            �sicion pos
     * 
     * @return Titular
     */
    public Titular buscarMJugador(ArrayList<Jugador> jugadores, Posicion pos) {
        int mayor = 0;
        int valor;
        Jugador jugadorElegido = new Jugador();

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            valor = jugador.getValor(pos);
            if (valor > mayor) {
                mayor = valor;
                jugadorElegido = jugador;
            }
        }
        return new Titular(pos, jugadorElegido);
    }

    public Formacion buscarLosTitulares(Formacion formacion, ArrayList<Jugador> jugadores) {

        Titular titular;
        for (int i = 0; i < this.getPosiciones().size(); i++) {
            Posicion posicionActual = this.getPosiciones().get(i);
            titular = this.buscarMJugador(jugadores, posicionActual);
            formacion.getTitulares().add(titular);

        }

        return formacion;

    }

    public List<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(List<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

}
