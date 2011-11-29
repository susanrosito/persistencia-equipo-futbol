package dominio.QuerysHibernateTest;

import junit.framework.TestCase;

import commands.EquiposConMasPartidosDeCopaGanadosCommandPerformante;
import commands.HibernateManager;

public class EquiposConMasPartidosGanadosPerformanteTest extends TestCase {
	public void testApp() throws Exception {

		long ti = System.currentTimeMillis();

		HibernateManager.instance().runInSession(
				new EquiposConMasPartidosDeCopaGanadosCommandPerformante());

		long tf = System.currentTimeMillis() - ti;
		System.out.println("La ejecución ha tardado: " + tf + " milisegundos");

	}

}
