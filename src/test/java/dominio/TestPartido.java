package dominio;

import dominio.Equipo;
import dominio.Partido;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

public class TestPartido extends TestCase {
	Equipo equipoA;
	Equipo equipoB;
	
	Partido partido;
	
	protected void setUp(){
		this.equipoA = createMock(Equipo.class);
		this.equipoB = createMock(Equipo.class);
		this.partido = new Partido(this.equipoA, this.equipoB);
		this.partido.setGolesEquipoA(3);
		this.partido.setGolesEquipoB(2);
	}
	
	public void testGanador(){
		Assert.assertEquals(this.equipoA, this.partido.getGanador());
		//partido empatado
		this.partido.setGolesEquipoA(2);
		Assert.assertNull(this.partido.getGanador());
	}
}
