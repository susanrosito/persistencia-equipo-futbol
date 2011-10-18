package Tests;

import junit.framework.TestCase;
import Commands.CantidadPartidosGanadosCommand;
import Commands.HibernateManager;

/**
 * TODO: description
 */
public class CantidadPartidosGanadosTest extends TestCase {

    public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo D", "Equipo E"));
        HibernateManager.instance().runInSession(new CantidadPartidosGanadosCommand("Equipo E", "Equipo D"));
    }

}
