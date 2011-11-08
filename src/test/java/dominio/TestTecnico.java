package dominio;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import interfaces.FormacionStrategy;
import dominio.Tecnico;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestTecnico extends TestCase {
	  FormacionStrategyImp formacionStrategy;
	  String nombre;
	  Tecnico tec;
		protected void setUp()
		{
			this.formacionStrategy = createMock(FormacionStrategyImp.class);
			
			this.nombre= "Domingo Augusto";
			this.tec= new Tecnico(this.nombre, formacionStrategy);
		}
		protected void tearDown()
		{
			this.formacionStrategy = null;
			
			this.nombre= null;
			this.tec= null;
		}
		
		public void testTecnico ()
		{
			Assert.assertEquals(this.nombre, this.tec.getNombre());
			Assert.assertEquals(this.formacionStrategy, this.tec.getFormacionStrategyImp());
		}

		public void testArmarFormacion() {
			expect(formacionStrategy.armarFormacion(null)).andReturn(null).once();
			replay(formacionStrategy);
			this.tec.armarFormacion(null);
			verify(formacionStrategy);
			
		}


		
		public void testGetNombre() {
			
			Assert.assertEquals(this.nombre, this.tec.getNombre());
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

}
