package dominio;

import interfaces.Habilidad;

public class HabilidadImp implements Habilidad {

    Posicion posicion;

    int valor;

    int id;

    public HabilidadImp() {
    }

    public HabilidadImp(final Posicion p, final int val) {
        this.posicion = p;
        this.valor = val;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(final Posicion posicion) {
        this.posicion = posicion;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(final int valor) {
        this.valor = valor;
    }

    @Override
    public int getValor(final Posicion p) {

        if (p == this.getPosicion()) {
            return this.valor;
        } else {
            return 0;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
