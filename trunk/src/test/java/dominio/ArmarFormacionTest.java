package dominio;

import junit.framework.TestCase;
import commands.ArmarFormacionCommand;
import commands.HibernateManager;

public class ArmarFormacionTest extends TestCase{
	
	public void testApp() throws Exception {
       HibernateManager.instance().runInSession(new ArmarFormacionCommand("Racing "));
		
	}

}
