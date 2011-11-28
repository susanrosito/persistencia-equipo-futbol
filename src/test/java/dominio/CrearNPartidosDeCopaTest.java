package dominio;

import commands.CrearNPartidosDeCopaRandomCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

public class CrearNPartidosDeCopaTest extends TestCase{
	
	public void testApp() throws Exception {
		long ti = System.currentTimeMillis();
		
		HibernateManager.instance().runInSession(new CrearNPartidosDeCopaRandomCommand(2000));
		
		long tf = System.currentTimeMillis() - ti;
	    System.out.println("La ejecución ha tardado: "+ tf + " milisegundos");
		
    }

}
