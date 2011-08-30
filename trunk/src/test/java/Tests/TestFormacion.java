package Tests;

import static org.easymock.EasyMock.createMock;

import java.util.ArrayList;

import Clases.Equipo;
import Clases.Formacion;
import Clases.Jugador;
import Clases.Titular;
import junit.framework.Assert;
import junit.framework.TestCase;

//Para mi esta al dope este test pero bue....lo reveo despues :P

public class TestFormacion extends TestCase {
	Titular mockTitular1;
	Titular mockTitular2;
	Titular mockTitular3;
	Titular mockTitular4;
	Jugador mockJugSupl1;
	Jugador mockJugSupl2;
	Jugador mockJugSupl3;
	ArrayList<Titular> titulares;
	ArrayList<Jugador> suplentes;
	Equipo equipo;
	Formacion formacion;
	
	protected void setUp(){
		this.mockTitular1 = createMock(Titular.class);
		this.mockTitular2 = createMock(Titular.class);
		this.mockTitular3 = createMock(Titular.class);
		this.mockTitular4 = createMock(Titular.class);
		this.titulares = new ArrayList<Titular>();
		this.titulares.add(this.mockTitular1);
		this.titulares.add(this.mockTitular2);
		this.titulares.add(this.mockTitular3);
		this.titulares.add(this.mockTitular4);
		this.mockJugSupl1 = createMock(Jugador.class);
		this.mockJugSupl2 = createMock(Jugador.class);
		this.mockJugSupl3 = createMock(Jugador.class);
		this.suplentes = new ArrayList<Jugador>();
		this.suplentes.add(this.mockJugSupl1);
		this.suplentes.add(this.mockJugSupl2);
		this.suplentes.add(this.mockJugSupl3);
		this.equipo = createMock(Equipo.class);
	}
	
	

	public void testConstructorFormacion(){
		this.formacion = new Formacion(this.titulares, this.suplentes, this.equipo);
		Assert.assertEquals(this.titulares, this.formacion.getTitulares());
		Assert.assertEquals(this.suplentes, this.formacion.getSuplentes());
		Assert.assertEquals(this.equipo, this.formacion.getEquipo());
	}
}
