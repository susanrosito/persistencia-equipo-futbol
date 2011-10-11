package Home;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import Clases.Equipo;
import Commands.HibernateManager;

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

}