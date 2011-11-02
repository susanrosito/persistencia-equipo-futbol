package dominio;

import commands.CantidadPartidosGanadosCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

/**
 * TODO: description
 */
public class CantidadPartidosGanadosTest extends TestCase  {

    public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo D", "Equipo E"));
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo E", "Equipo D"));
    
     
    }

}
