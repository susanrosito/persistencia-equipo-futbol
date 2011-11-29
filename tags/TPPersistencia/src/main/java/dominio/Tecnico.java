package dominio;

import interfaces.FormacionStrategy;
import interfaces.Nombrable;

public class Tecnico implements Nombrable {

    private int id;
    private String nombre;
    private FormacionStrategy formacionStrategy;

    public Tecnico(final String nombre, final FormacionStrategy fsi) {
        this.nombre = nombre;
        this.formacionStrategy = fsi;
    }

    public Tecnico() {
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public Formacion armarFormacion(final Equipo e) {
        return this.formacionStrategy.armarFormacion(e);
    }

    public FormacionStrategy getFormacionStrategy() {
        return this.formacionStrategy;
    }

    public void setFormacionStrategy(final FormacionStrategy formacionStrategy) {
        this.formacionStrategy = formacionStrategy;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
