package Tests;

import Clases.Equipo;

import Clases.Tecnico;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.easymock.EasyMock.*;


public class TestEquipo extends TestCase {
  Equipo tstEquipo;
  String nombre;
  Tecnico tec;
	protected void setUp()
	{
		this.tec = createMock(Tecnico.class);
		
		this.nombre= "Alfa";
		this.tstEquipo= new Equipo(this.nombre, tec);
	}
	protected void tearDown()
	{
		this.tstEquipo=null;
	}
	
	public void testEquipo ()
	{
		Assert.assertEquals(this.nombre, this.tstEquipo.getNombre());
		Assert.assertEquals(this.tec, this.tstEquipo.getTecnico());
	}

	public void testArmarFormacion() {
		expect(tec.armarFormacion(this.tstEquipo)).andReturn(null).once();
		replay(tec);
		this.tstEquipo.armarFormacion();
		verify(tec);
		
	}


	
	public void testGetNombre() {
		
		Assert.assertEquals(this.nombre, this.tstEquipo.getNombre());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
