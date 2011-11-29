package dominio;

public class PartidoSimple extends Partido {

    private Formacion formacionA;
    private Formacion formacionB;

    public PartidoSimple(final Equipo a, final Equipo b) {
        super(a, b);
        this.formacionA = this.getEquipoA().armarFormacion();
        this.formacionB = this.getEquipoA().armarFormacion();
    }

    public PartidoSimple() {
    }

    public Formacion getFormacionA() {
        return this.formacionA;
    }

    public void setFormacionA(final Formacion formacionA) {
        this.formacionA = formacionA;
    }

    public Formacion getFormacionB() {
        return this.formacionB;
    }

    public void setFormacionB(final Formacion formacionB) {
        this.formacionB = formacionB;
    }

}
