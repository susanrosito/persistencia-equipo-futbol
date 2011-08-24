package Tests;

import Clases.Equipo;

import Clases.Tecnico;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.easymock.EasyMock.*;


public class TestEquipo extends TestCase {
  Equipo testEquipo;
  String nombre;
  Tecnico tec;
	protected void setUp()
	{
		this.tec = createMock(Tecnico.class);
		this.nombre= "Alfa";
		this.testEquipo= new Equipo(this.nombre, tec);
	}
	protected void tearDown()
	{
		this.testEquipo=null;
	}
	public void testEquipo (String nombre, Tecnico tec)
	{
		Assert.assertEquals(this.nombre, this.testEquipo.getNombre());
		Assert.assertEquals(this.tec, this.testEquipo.getTecnico());
	}

	public void testArmarFormacion(Equipo e) {
		
	}


	
	public void testGetNombre() {
		
		Assert.assertEquals(this.nombre, this.testEquipo.getNombre());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
