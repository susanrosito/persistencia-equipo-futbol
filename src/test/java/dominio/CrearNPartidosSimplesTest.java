package dominio;

import commands.CrearNPartidosSimplesRandomCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

public class CrearNPartidosSimplesTest extends TestCase{
	
	public void testApp() throws Exception {
		long ti = System.currentTimeMillis();
		
		HibernateManager.instance().runInSession(new CrearNPartidosSimplesRandomCommand(5));
		
		long tf = System.currentTimeMillis() - ti;
	    System.out.println("La ejecución ha tardado: "+ tf + " milisegundos");
		
    }
}
