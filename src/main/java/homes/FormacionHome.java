package homes;


import org.hibernate.classic.Session;

import commands.HibernateManager;

import dominio.Formacion;

public class FormacionHome {
	
	public void save(Formacion form){
		Session session = HibernateManager.instance().getSession();
		
		session.saveOrUpdate(form);		
		
	}

}
