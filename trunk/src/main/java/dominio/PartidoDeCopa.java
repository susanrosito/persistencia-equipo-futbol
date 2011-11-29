package dominio;

public class PartidoDeCopa extends Partido {

	private PartidoSimple primerPartido;
	private PartidoSimple segundoPartido;
	private int penalesConvertidosEquipoA;
	private int penalesConvertidosEquipoB;
	private Equipo ganadorP;
	private int id;

	public PartidoDeCopa(final Equipo a, final Equipo b) {
		super(a, b);
		this.primerPartido = new PartidoSimple(a, b);
		this.segundoPartido = new PartidoSimple(a, b);
		// this.setGanadorP(this.getGanador());
	}

	public PartidoDeCopa() {
	}

	@Override
	public Equipo getGanadorP() {
		Equipo ganador = this.verificarGanador();
		if (ganador == null) {
			ganador = this.definicionPorPenales();
		}
		// ganador.setCantPartidosDeCopaGanados(ganador.getCantPartidosDeCopaGanados()
		// + 1);

		this.ganadorP = ganador;
		return this.ganadorP;
	}

	private Equipo definicionPorPenales() {
		if (this.penalesConvertidosEquipoA > this.penalesConvertidosEquipoB) {
			return this.getEquipoA();
		} else {
			return this.getEquipoB();
		}
	}

	public Equipo verificarGanador() {
		Equipo ganadorUno = this.primerPartido.getGanadorP();
		Equipo ganadorDos = this.segundoPartido.getGanadorP();
		Equipo ganadorGlobal = null;

		if (!(ganadorUno == null && ganadorDos == null)) {

			if (ganadorUno == null & ganadorDos != null) {
				ganadorGlobal = ganadorDos;
			} else {
				if (ganadorUno != null & ganadorDos == null) {
					ganadorGlobal = ganadorUno;
				} else {
					if (ganadorUno.equals(ganadorDos)) {
						ganadorGlobal = ganadorUno;
					} else {
						if (ganadorUno.equals(ganadorDos)) {
							ganadorGlobal = ganadorUno;

						}
					}
				}
			}

		}
		return ganadorGlobal;
	}

	public PartidoSimple getPrimerPartido() {
		return this.primerPartido;
	}

	public void setPrimerPartido(final PartidoSimple primerPartido) {
		this.primerPartido = primerPartido;
	}

	public int getPenalesConvertidosEquipoA() {
		return this.penalesConvertidosEquipoA;
	}

	public void setPenalesConvertidosEquipoA(final int n) {
		this.penalesConvertidosEquipoA = n;
	}

	public int getPenalesConvertidosEquipoB() {
		return this.penalesConvertidosEquipoB;
	}

	public void setPenalesConvertidosEquipoB(final int n) {
		this.penalesConvertidosEquipoB = n;
	}

	public PartidoSimple getSegundoPartido() {
		return this.segundoPartido;
	}

	public void setSegundoPartido(final PartidoSimple segundoPartido) {
		this.segundoPartido = segundoPartido;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(final int id) {
		this.id = id;
	}

	public void setGanadorP(final Equipo ganadorP) {
		this.ganadorP = ganadorP;
	}

}
