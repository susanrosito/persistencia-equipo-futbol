package homes;

import org.hibernate.classic.Session;

import commands.HibernateManager;

public class Home {

	private Session session;
	
	public void  crearTecnicos(){
		Session sessionA = HibernateManager.instance().getSession();
		
	}
	
	

}

