package Tests;

import java.util.ArrayList;
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
	Jugador jugador;
	
	
	protected void setUp(){
		this.nombre = "Lalo Landa";
		this.mockHab1 = createMock(HabilidadImp.class);
		this.mockHab2 = createMock(HabilidadImp.class);
		this.mockHab3 = createMock(HabilidadImp.class);
		this.habilidades = new ArrayList<HabilidadImp>();
		this.habilidades.add(mockHab1);
		this.habilidades.add(mockHab2);
		this.habilidades.add(mockHab3);
		this.jugador = new Jugador(this.nombre, this.habilidades);
	}
	
	public void testGetValor(){
		expect(this.mockHab1.getValor(Posicion.DELANTERO)).andReturn(8);
		expect(this.mockHab1.getValor(Posicion.LATERAL)).andReturn(0);
		expect(this.mockHab1.getValor(Posicion.CENTRAL)).andReturn(0);
		expect(this.mockHab1.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
		expect(this.mockHab2.getValor(Posicion.LATERAL)).andReturn(3);
		expect(this.mockHab2.getValor(Posicion.DELANTERO)).andReturn(0);
		expect(this.mockHab2.getValor(Posicion.CENTRAL)).andReturn(0);
		expect(this.mockHab2.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
		expect(this.mockHab3.getValor(Posicion.CENTRAL)).andReturn(5);
		expect(this.mockHab3.getValor(Posicion.DELANTERO)).andReturn(0);
		expect(this.mockHab3.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
		expect(this.mockHab3.getValor(Posicion.LATERAL)).andReturn(0);
		
		replay(mockHab1);
		replay(mockHab2);
		replay(mockHab3);
		
		Assert.assertEquals(8, this.jugador.getValor(Posicion.DELANTERO));
		Assert.assertEquals(3, this.jugador.getValor(Posicion.LATERAL));
		Assert.assertEquals(5, this.jugador.getValor(Posicion.CENTRAL));
		Assert.assertEquals(0, this.jugador.getValor(Posicion.MEDIA_PUNTA));
		
		verify(mockHab1);
		verify(mockHab2);
		verify(mockHab3);
		
				
	}
	
}
