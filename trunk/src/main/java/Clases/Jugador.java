package Clases;

import java.util.List;

import Interfaces.Habilidad;
import Interfaces.Nombrable;

public class Jugador implements Nombrable, Habilidad {
    private String nombre;

    private int id;

    private List<HabilidadImp> habilidades;

    public Jugador() {

    }

    public Jugador(final String nomb, final List<HabilidadImp> habs) {
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
        // falta crear habilidad en caso de no encontrarla
        for (HabilidadImp habAc : this.getHabilidades()) {
            if (habAc.getPosicion() == hab.getPosicion()) {
                habAc.setValor(hab.getValor());
                break;
            }
        }
    }

    public void setHabilidades(final List<HabilidadImp> habilidades) {
        this.habilidades = habilidades;
    }

    public List<HabilidadImp> getHabilidades() {
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
