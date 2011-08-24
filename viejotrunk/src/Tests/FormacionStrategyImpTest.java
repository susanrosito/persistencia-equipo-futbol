package Tests;

import java.util.ArrayList;

import Clases.FormacionStrategyImp;
import Clases.Jugador;
import Clases.Posicion;
import static org.easymock.EasyMock.*;
import junit.framework.TestCase;

public class FormacionStrategyImpTest extends TestCase {

	 FormacionStrategyImp formacionImp;
	 ArrayList<Jugador> jugadores;
	 ArrayList<Posicion> posiciones;
	 Posicion posicion;
	 @Override
	protected void setUp() throws Exception {
		
		
		this.posicion = createMock(Posicion.class);
		this.formacionImp = new FormacionStrategyImp(posiciones);
		
		
	 }

	
	 @Override
	protected void tearDown() throws Exception {
	  
		
	 
	 }
	
	public void testFormacionStrategyImp(){
		
		
	}
	
	public void testArmarFormacion(){
		
		
	}
	
	public void testBuscarJugador(){
		
		
	}
}
