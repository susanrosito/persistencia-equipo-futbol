package dominio;

import interfaces.Habilidad;
import interfaces.Nombrable;

import java.util.HashSet;
import java.util.Set;


public class Jugador implements Nombrable, Habilidad {
    private String nombre;

    private Set<HabilidadImp> habilidades;

    private Equipo equipo;

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(final Equipo equipo) {
        this.equipo = equipo;
    }

    private int id;

    public Jugador() {
        this.habilidades = new HashSet<HabilidadImp>();
    }

    public Jugador(final String nomb, final HashSet<HabilidadImp> habs) {
        this.nombre = nomb;
        this.habilidades = habs;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getValor(final Posicion p) {
        int valor = 0;
        int maxVal = 0;
        for (HabilidadImp hab : this.getHabilidades()) {
            valor = hab.getValor(p);
            if (valor > maxVal) {
                maxVal = valor;
            }
        }
        return maxVal;
    }

    public void setHabilidad(final HabilidadImp hab, final int val) {
        for (HabilidadImp habAc : this.getHabilidades()) {
            if (habAc.getPosicion() == hab.getPosicion()) {
                habAc.setValor(hab.getValor());
                return;
            }
        }
        this.habilidades.add(hab);
    }

    public void setHabilidades(final Set<HabilidadImp> habilidades) {
        this.habilidades = habilidades;
    }

    public Set<HabilidadImp> getHabilidades() {
        return this.habilidades;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

}
