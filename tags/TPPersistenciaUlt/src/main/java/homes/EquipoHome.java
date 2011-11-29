package homes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import commands.HibernateManager;

import dominio.Equipo;


/**
 * TODO: description
 */

public class EquipoHome {
	
	
	public Equipo getByName(final String nombre) {
		   Session session = HibernateManager.instance().getSession();
        Criteria criteria = session.createCriteria(Equipo.class);
        criteria.add(Expression.eq("nombre", nombre));
        return (Equipo) criteria.uniqueResult();
    }

	public void setNEquipos(List<Equipo> equipo){
		Session session = HibernateManager.instance().getSession();
		for (Equipo equipoActual : equipo) {
			session.saveOrUpdate(equipoActual);
		}
	}
	
	 public ArrayList<Equipo> getEquipos(){
	        Session session = HibernateManager.instance().getSession();
	        Query q = session.createQuery("from Equipo").setCacheable(true);
	        return (ArrayList<Equipo>) q.list();
	 }
}
