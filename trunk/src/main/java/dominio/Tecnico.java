package dominio;

import interfaces.FormacionStrategy;
import interfaces.Nombrable;

public class Tecnico implements Nombrable {

    private int id;

    private String nombre;

    private FormacionStrategyImp formacionStrategyImp;

    public Tecnico(final String nombre, final FormacionStrategyImp fsi) {
        this.nombre = nombre;
        this.formacionStrategyImp = fsi;
    }

    public Tecnico() {

    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public Formacion armarFormacion(final Equipo e) {
        return this.formacionStrategyImp.armarFormacion(e);
    }

    public FormacionStrategyImp getFormacionStrategyImp() {
        return this.formacionStrategyImp;
    }

    public void setFormacionStrategyImp(final FormacionStrategyImp formacionStrategy) {
        this.formacionStrategyImp = formacionStrategy;
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
