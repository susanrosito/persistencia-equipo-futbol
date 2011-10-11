package Tests;

import junit.framework.TestCase;
import Commands.CambiarTecnicoCommand;
import Commands.HibernateManager;

/**
 * TODO: description
 */
public class CambiarTecnicoTest extends TestCase {

    public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new CambiarTecnicoCommand("Equipo C", "Ruperto"));
    }
}
