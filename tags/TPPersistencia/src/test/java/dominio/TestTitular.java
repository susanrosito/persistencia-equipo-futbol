package dominio;

import static org.easymock.EasyMock.createMock;
import dominio.Jugador;
import dominio.Posicion;
import dominio.Titular;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestTitular extends TestCase {

	Posicion posicion ;
	Titular titular;
	Jugador jugador;

	protected void setUp(){
		this.posicion = Posicion.CENTRAL;
		this.jugador = createMock(Jugador.class);
		this.titular= new Titular(this.posicion, this.jugador);
	}
	
	protected void tearDown(){
		this.posicion = null;
		this.jugador = null;
		this.titular= null;
	}
	
	public void testTitular (){
		Assert.assertSame(this.posicion, this.titular.getPosicion());
		Assert.assertSame(this.jugador, this.titular.getJugador());
	}

}
