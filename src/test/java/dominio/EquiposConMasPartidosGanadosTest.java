package dominio;

import junit.framework.TestCase;

import commands.EquiposConMasPartidosGanadosCommand;
import commands.HibernateManager;

/**
 * TODO: description
 */
public class EquiposConMasPartidosGanadosTest extends TestCase {
    public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new EquiposConMasPartidosGanadosCommand());

    }
}
