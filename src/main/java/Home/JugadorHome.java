package Home;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import Clases.Jugador;
import Commands.HibernateManager;

/**
 * TODO: description
 */
public class JugadorHome {

    public Jugador getByName(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Criteria criteria = session.createCriteria(Jugador.class);
        criteria.add(Expression.eq("nombre", nombre));
        return (Jugador) criteria.uniqueResult();
    }
}
