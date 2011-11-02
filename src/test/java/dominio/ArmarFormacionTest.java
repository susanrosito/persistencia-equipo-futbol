package dominio;

import commands.ArmarFormacionCommand;
import commands.HibernateManager;
import junit.framework.TestCase;

public class ArmarFormacionTest extends TestCase{
	
	public void testApp() throws Exception {
        HibernateManager.instance().runInSession(new ArmarFormacionCommand("Equipo C"));
    
	}

}
