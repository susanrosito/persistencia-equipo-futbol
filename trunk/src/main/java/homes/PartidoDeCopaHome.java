package homes;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import commands.HibernateManager;

import dominio.Equipo;

public class PartidoDeCopaHome {

    public ArrayList<Equipo> getPartidosDeCopaGanadosPorEquipo() {
        Session session = HibernateManager.instance().getSession();
        /*
         * Criteria criteria = session.createCriteria(PartidoDeCopa.class); Criteria criteria1 =
         * session.createCriteria(PartidoDeCopa.class); .groupProperty("title") Criteria criteriaEquipoLocal =
         * criteria.createCriteria("ganadorP"); criteriaEquipoLocal.add(eq("nombre", nombre)) .addOrder(
         * Order.desc("age") );
         */

        Query query = session
                .createQuery("select ganador from (select pc.ganadorP as ganador, count(*) as ganados from PartidoDeCopa as pc group by ganador order by ganados asc)");

        return (ArrayList<Equipo>) query.list();

        /*
         * criteria.add(geProperty("golesEquipoA", "golesEquipoB")); return criteria.list().size();
         */

    }

}
