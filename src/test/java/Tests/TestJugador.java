package Tests;

import java.util.List;

import Clases.HabilidadImp;
import Clases.Jugador;
import Clases.Posicion;

import junit.framework.Assert;
import junit.framework.TestCase;

import static org.easymock.EasyMock.*;

public class TestJugador extends TestCase {
	String nombre;
	HabilidadImp mockHab1;
	HabilidadImp mockHab2;
	HabilidadImp mockHab3;
	List<HabilidadImp> habilidades;
	Posicion pos1;
	Posicion pos2;
	Jugador jugador;
	
	
	protected void setUp(){
		this.nombre = "Lalo Landa";
		this.mockHab1 = createMock(HabilidadImp.class);
		this.mockHab2 = createMock(HabilidadImp.class);
		this.mockHab3 = createMock(HabilidadImp.class);
		this.pos1 = createMock(Posicion.class);
		this.pos2 = createMock(Posicion.class);
		this.habilidades.add(mockHab1);
		this.habilidades.add(mockHab2);
		this.habilidades.add(mockHab3);
		this.jugador = new Jugador(this.nombre, this.habilidades);
	}
	
	public void testGetValor(){
		expect(this.mockHab1.getValor(Posicion.ARQUERO)).andReturn(0);
		expect(this.mockHab1.getValor(Posicion.DELANTERO)).andReturn(8);
		replay(mockHab1);
		Assert.assertEquals(0, this.jugador.getValor(Posicion.ARQUERO));
		Assert.assertEquals(8, this.jugador.getValor(Posicion.DELANTERO));
		verify(mockHab1);
		
				
	}
	
}
