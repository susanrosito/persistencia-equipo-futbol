package dominio.QuerysHibernateTest;

import commands.CambiarTecnicoCommand;
import commands.HibernateManager;

import junit.framework.TestCase;

/**
 * TODO: description
 */
public class CambiarTecnicoTest extends TestCase {

	public void testApp() throws Exception {
		HibernateManager.instance().runInSession( 
				new CambiarTecnicoCommand("Racing ", "Migenso Figo 3"));

	}
}
