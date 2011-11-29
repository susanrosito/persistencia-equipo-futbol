package homes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import commands.HibernateManager;
import dominio.Jugador;


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

    public void guardarJugadores(List<Jugador> jugadores){
    	Session session = HibernateManager.instance().getSession();
    	for (Jugador jugador : jugadores) {
			session.save(jugador);
		}
    }  
}
