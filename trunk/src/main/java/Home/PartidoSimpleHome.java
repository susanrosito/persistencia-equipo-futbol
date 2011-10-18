package Home;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Commands.HibernateManager;

/**
 * TODO: description
 */
public class PartidoSimpleHome {

    public int getCantPartidosSimplesLocalesGanadosPor(final String nombre, final String nombre2) {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("from PartidoSimple as ps where ps.equipoA.nombre = ? and ps.equipoB.nombre = ? and ps.golesEquipoA > ps.golesEquipoB ");
        query.setString(0, nombre);
        query.setString(1, nombre2);
        return query.list().size();
    }

    public int getCantPartidosSimplesVisitantesGanadosPor(final String nombre, final String nombre2) {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("from PartidoSimple as ps where ps.equipoB.nombre = ? and ps.equipoA.nombre = ? and ps.golesEquipoB > ps.golesEquipoA");
        query.setString(0, nombre);
        query.setString(1, nombre2);
        return query.list().size();
    }

    public int getCantPartidosSimplesEmpatadosEntre(final String nombre, final String nombre2) {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("from PartidoSimple as ps where ((ps.equipoA.nombre = ? and ps.equipoB.nombre = ?) or (ps.equipoA.nombre = ? and ps.equipoB.nombre = ?)) and ps.golesEquipoB = ps.golesEquipoA");
        query.setString(0, nombre);
        query.setString(1, nombre2);
        query.setString(2, nombre2);
        query.setString(3, nombre);

        return query.list().size();
    }
}
