package Clases;

public class PartidoSimple extends Partido {

	private Formacion formacionA;
	private Formacion formacionB;

	PartidoSimple(Equipo a, Equipo b) {
		super(a, b);
		this.formacionA = this.getEquipoA().armarFormacion();
		this.formacionB = this.getEquipoA().armarFormacion();
	}
	
	

	public Formacion getFormacionA() {
		return formacionA;
	}

	public void setFormacionA(Formacion formacionA) {
		this.formacionA = formacionA;
	}

	public Formacion getFormacionB() {
		return formacionB;
	}

	public void setFormacionB(Formacion formacionB) {
		this.formacionB = formacionB;
	}
	
	

}
