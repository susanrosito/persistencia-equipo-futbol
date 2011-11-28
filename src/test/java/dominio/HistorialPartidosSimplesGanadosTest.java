package dominio;

import commands.HistorialPartidosSimplesGanadosCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

/**
 * TODO: description
 */
public class HistorialPartidosSimplesGanadosTest extends TestCase  {

    public void testApp() throws Exception {
    	
    	long ti = System.currentTimeMillis();
        
    	HibernateManager.instance().runInSession(new HistorialPartidosSimplesGanadosCommand("Lanus ", "Gody Cruz "));
        HibernateManager.instance().runInSession(new HistorialPartidosSimplesGanadosCommand("Gody Cruz ", "Lanus "));
        long td = System.currentTimeMillis() - ti;
        
        System.out.println("La query tardó: " + td);
     
    }

}
