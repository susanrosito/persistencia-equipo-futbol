package Home;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Clases.PartidoSimple;
import Commands.HibernateManager;

/**
 * TODO: description
 */
public class PartidoSimpleHome {

    public Set<PartidoSimple> getPartidosSimplesLocalesGanadosPor(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("from PartidoSimple as ps where ps.equipoA.nombre = ? and ps.golesEquipoA > ps.golesEquipoB");
        query.setString(0, nombre);
        return (Set<PartidoSimple>) query.list();
    }

    public Set<PartidoSimple> getPartidosSimplesVisitantesGanadosPor(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("from PartidoSimple as ps where ps.equipoB.nombre = ? and ps.golesEquipoB > ps.golesEquipoA");
        query.setString(0, nombre);
        return (Set<PartidoSimple>) query.list();
    }

}
