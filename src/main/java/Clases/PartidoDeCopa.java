package Clases;

public class PartidoDeCopa extends Partido {

	private PartidoSimple primerPartido;
	private PartidoSimple segundoPartido;

	PartidoDeCopa(Equipo a, Equipo b) {
		super(a, b);
		this.primerPartido = new PartidoSimple(a,b);
		this.segundoPartido = new PartidoSimple(a,b);
		
	}

	protected Equipo getGanador(){
		
		Equipo ganadorUno = this.primerPartido.getGanador();
		Equipo ganadorDos = this.segundoPartido.getGanador();
		
		
		
		if(ganadorUno.equals(ganadorDos))
		{ return ganadorUno;}
		if(ganadorUno==null & ! (ganadorDos==null ))
		{ return ganadorDos;}
		if(!(ganadorUno==null ) & ganadorDos==null)
		{ return ganadorDos;}
		if(ganadorUno==null & ganadorDos==null)
		{
			return super.getGanador();
		}
		if(ganadorUno.equals(ganadorDos))
		{ return ganadorUno;}
		
		
		
		
	}
	public PartidoSimple getPrimerPartido() {
		return primerPartido;
	}

	public void setPrimerPartido(PartidoSimple primerPartido) {
		this.primerPartido = primerPartido;
	}

	public PartidoSimple getSegundoPartido() {
		return segundoPartido;
	}

	public void setSegundoPartido(PartidoSimple segundoPartido) {
		this.segundoPartido = segundoPartido;
	}


}
