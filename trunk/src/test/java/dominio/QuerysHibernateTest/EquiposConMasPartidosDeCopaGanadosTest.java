package dominio.QuerysHibernateTest;

import junit.framework.TestCase;

import commands.EquiposConMasPartidosGanadosDeCopaCommand;
import commands.HibernateManager;

/**
 * TODO: description
 */
public class EquiposConMasPartidosDeCopaGanadosTest extends TestCase {
	public void testApp() throws Exception {

		long ti = System.currentTimeMillis();

		HibernateManager.instance().runInSession(
				new EquiposConMasPartidosGanadosDeCopaCommand());

		long tf = System.currentTimeMillis() - ti;
		System.out.println("La ejecución ha tardado: " + tf + " milisegundos");

	}
}
