package homes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import commands.HibernateManager;

import dominio.Equipo;

public class PartidoDeCopaHome {

    @SuppressWarnings("unchecked")
    public List<Equipo> getPartidosDeCopaGanadosPorEquipo() {
        Session session = HibernateManager.instance().getSession();
        /*
         * Criteria criteria = session.createCriteria(PartidoDeCopa.class); Criteria criteria1 =
         * session.createCriteria(PartidoDeCopa.class); .groupProperty("title") Criteria criteriaEquipoLocal =
         * criteria.createCriteria("ganadorP"); criteriaEquipoLocal.add(eq("nombre", nombre)) .addOrder(
         * Order.desc("age") );
         */

        Query query = session
                .createQuery("select pc.ganadorP as ganador, count(*) as ganados from PartidoDeCopa as pc group by ganador order by ganados asc");

        List<Equipo> equipos = new ArrayList<Equipo>();

        for (Object[] r : (List<Object[]>) query.list()) {
            equipos.add((Equipo) r[0]);
        }

        return equipos;

        /*
         * criteria.add(geProperty("golesEquipoA", "golesEquipoB")); return criteria.list().size();
         */

    }
}
