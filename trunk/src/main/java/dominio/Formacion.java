package dominio;

import java.util.List;

public class Formacion {

    private List<Titular> Titulares;

    private List<Jugador> Suplentes;

    private Equipo equipo;

    private int id;

    public Formacion() {
    }

    public Formacion(final List<Titular> ts, final List<Jugador> ss, final Equipo e) {
        this.Titulares = ts;
        this.Suplentes = ss;
        this.equipo = e;
    }

    public List<Titular> getTitulares() {
        return this.Titulares;
    }

    public Jugador getSuplente(final int n) {
        return this.getSuplentes().get(n);

    }

    public void setTitulares(final List<Titular> titulares) {
        this.Titulares = titulares;
    }

    public List<Jugador> getSuplentes() {
        return this.Suplentes;
    }

    public void setSuplentes(final List<Jugador> suplentes) {
        this.Suplentes = suplentes;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(final Equipo equipo) {
        this.equipo = equipo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
