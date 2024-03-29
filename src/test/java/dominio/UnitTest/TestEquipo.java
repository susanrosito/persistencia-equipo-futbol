package dominio.UnitTest;

import java.util.ArrayList;
import java.util.List;

import dominio.Equipo;
import dominio.Formacion;
import dominio.Jugador;
import dominio.Tecnico;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

public class TestEquipo extends TestCase {
	Equipo tstEquipo;
	String nombre;
	Tecnico tec;
	List<Jugador> jug;

	protected void setUp() {
		this.tec = createMock(Tecnico.class);
		this.jug = new ArrayList<Jugador>();
		this.nombre = "Alfa";
		this.tstEquipo = new Equipo(this.nombre, tec, jug);
	}

	protected void tearDown() {
		this.tstEquipo = null;
	}

	public void testEquipo() {
		Assert.assertEquals(this.nombre, this.tstEquipo.getNombre());
		Assert.assertEquals(this.tec, this.tstEquipo.getTecnico());
		Assert.assertEquals(this.jug, this.tstEquipo.getJugadores());
	}

	public void testArmarFormacion() {
		Formacion f = createMock(Formacion.class);
		expect(tec.armarFormacion(this.tstEquipo)).andReturn(f).once();
		replay(tec);
		Assert.assertEquals(f, this.tstEquipo.armarFormacion());
		verify(tec);

	}

	public void testGetNombre() {
		Assert.assertEquals(this.nombre, this.tstEquipo.getNombre());
	}

}
