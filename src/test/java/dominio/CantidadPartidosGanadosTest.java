package dominio;

import commands.CantidadPartidosGanadosCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

/**
 * TODO: description
 */
public class CantidadPartidosGanadosTest extends TestCase  {

    public void testApp() throws Exception {
    	long ti = System.currentTimeMillis();
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo A", "Equipo B"));
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo B", "Equipo A"));
        long td = System.currentTimeMillis() - ti;
        System.out.println("La query tardó: " + td);
     
    }

}
