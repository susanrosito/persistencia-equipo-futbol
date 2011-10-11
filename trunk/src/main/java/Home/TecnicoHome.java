package Home;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Clases.Tecnico;
import Commands.HibernateManager;

/**
 * TODO: description
 */
public class TecnicoHome {
    public Tecnico getByName(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Query query = session.createQuery("from Tecnico where nombre = ?");
        query.setString(0, nombre);
        return (Tecnico) query.uniqueResult();
    }

}
