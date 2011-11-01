package dominio;

import commands.EquiposConMasPartidosGanadosCommand;
import commands.HibernateManager;

/**
 * TODO: description
 */
public class EquiposConMasPartidosGanadosTest {
    public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new EquiposConMasPartidosGanadosCommand());

    }
}
