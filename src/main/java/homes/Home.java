package homes;

import java.util.List;

import org.hibernate.classic.Session;

import commands.HibernateManager;

public class Home {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	
	
	
	

}

