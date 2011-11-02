package homes;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import commands.HibernateManager;

import dominio.Tecnico;


/**
 * TODO: description
 */
public class TecnicoHome {
    
	public Tecnico getByName(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Criteria criteria = session.createCriteria(Tecnico.class);
        criteria.add(Expression.eq("nombre", nombre));
        return (Tecnico) criteria.uniqueResult();

    }
    
    public void guardarTecnico(Tecnico tecnico ){
    Session	session = HibernateManager.instance().getSession();
    	session.save(tecnico);
    }
    
    
    
}
