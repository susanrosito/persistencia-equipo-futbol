package Clases;

public class PartidoDeCopa extends Partido {

	private PartidoSimple primerPartido;
	private PartidoSimple segundoPartido;
	
	private int penalesConvertidosEquipoA;
	private int penalesConvertidosEquipoB;
	
	
	public PartidoDeCopa(Equipo a, Equipo b) {
		super(a, b);
		this.primerPartido = new PartidoSimple(a,b);
		this.segundoPartido = new PartidoSimple(a,b);
	}

	public Equipo getGanador(){
		Equipo ganador = this.verificarGanador();
		if(ganador == null){
			ganador = this.definicionPorPenales();
		}
		return ganador;
	}
	
	private Equipo definicionPorPenales() {
		
		return null;
	}

	public Equipo verificarGanador(){
		Equipo ganadorUno = this.primerPartido.getGanador();
		Equipo ganadorDos = this.segundoPartido.getGanador();
		Equipo ganadorGlobal = null;
		
		
		if(ganadorUno.equals(ganadorDos))
		{ ganadorGlobal = ganadorUno;}
		if(ganadorUno==null & ! (ganadorDos==null ))
		{ ganadorGlobal = ganadorDos;}
		if(!(ganadorUno==null ) & ganadorDos==null)
		{ ganadorGlobal = ganadorUno;}
		if(ganadorUno.equals(ganadorDos))
		{ ganadorGlobal = ganadorUno;}
		
		return ganadorGlobal;
	}
	
	public PartidoSimple getPrimerPartido() {
		return primerPartido;
	}

	public void setPrimerPartido(PartidoSimple primerPartido) {
		this.primerPartido = primerPartido;
	}
	
	public int getPenalesConvertidosEquipoA() {
		return this.penalesConvertidosEquipoA;
	}

	public void setPenalesConvertidosEquipoA(int n){
		this.penalesConvertidosEquipoA = n;
	}
	
	public int getPenalesConvertidosEquipoB() {
		return this.penalesConvertidosEquipoB;
	}

	public void setPenalesConvertidosEquipoB(int n){
		this.penalesConvertidosEquipoB = n;
	}

	public PartidoSimple getSegundoPartido() {
		return segundoPartido;
	}

	public void setSegundoPartido(PartidoSimple segundoPartido) {
		this.segundoPartido = segundoPartido;
	}


}
