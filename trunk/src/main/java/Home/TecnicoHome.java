package Home;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import Clases.Tecnico;
import Commands.HibernateManager;

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

}
