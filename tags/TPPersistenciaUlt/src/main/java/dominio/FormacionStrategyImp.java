package dominio;

import interfaces.FormacionStrategy;

import java.util.ArrayList;
import java.util.List;

public class FormacionStrategyImp implements FormacionStrategy {

    private List<Posicion> posiciones;
    int id;

    public FormacionStrategyImp(final List<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public FormacionStrategyImp() {
    }

    @Override
    public Formacion armarFormacion(final Equipo e) {

        List<Jugador> jugadores = e.getJugadores();
        Formacion formacion = new Formacion(new ArrayList<Titular>(), new ArrayList<Jugador>(), e);
        formacion = this.buscarTitulares(formacion, jugadores);
        formacion.getSuplentes().addAll(jugadores);

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
    public Titular buscarMJugador(final ArrayList<Jugador> jugadores, final Posicion pos) {

        int valor;
        Jugador jugadorElegido = jugadores.get(0);
        int mayor = jugadorElegido.getValor(pos);

        for (int i = 1; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            valor = jugador.getValor(pos);
            if (valor > mayor) {
                mayor = valor;
                jugadorElegido = jugador;
            }
        }
        return new Titular(pos, jugadorElegido);
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
    public Titular buscarMJugador(final List<Jugador> jugadores, final Posicion pos) {

        int valor;
        Jugador jugadorElegido = jugadores.get(0);
        int mayor = jugadorElegido.getValor(pos);

        for (int i = 1; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            valor = jugador.getValor(pos);
            if (valor > mayor) {
                mayor = valor;
                jugadorElegido = jugador;
            }
        }
        return new Titular(pos, jugadorElegido);
    }

    public Formacion buscarTitulares(final Formacion formacion, final List<Jugador> jugadores) {

        Titular titular;
        for (int i = 0; i < this.getPosiciones().size(); i++) {
            Posicion posicionActual = this.getPosiciones().get(i);
            titular = this.buscarMJugador(jugadores, posicionActual);
            formacion.getTitulares().add(titular);

        }
        return formacion;
    }

    public Jugador getSuplente(final int i, final Formacion f) {
        return f.getSuplentes().get(i);
    }

    public List<Posicion> getPosiciones() {
        return this.posiciones;
    }

    public void setPosiciones(final List<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(final int i) {
        this.id = i;
    }

}
