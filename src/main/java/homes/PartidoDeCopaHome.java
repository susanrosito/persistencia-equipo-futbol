package homes;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import commands.HibernateManager;

public class PartidoDeCopaHome {

    public int getCantPartidosDeCopaGanadosPor(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        /*
         * Criteria criteria = session.createCriteria(PartidoDeCopa.class); Criteria criteria1 =
         * session.createCriteria(PartidoDeCopa.class); .groupProperty("title") Criteria criteriaEquipoLocal =
         * criteria.createCriteria("ganadorP"); criteriaEquipoLocal.add(eq("nombre", nombre)) .addOrder(
         * Order.desc("age") );
         */

        Query query = session
                .createQuery("select pc.ganadorP, count(*) as ganados from PartidoDeCopa as pc group by pc.ganadprP order by ganados asc");

        return query.list().size();

        /*
         * criteria.add(geProperty("golesEquipoA", "golesEquipoB")); return criteria.list().size();
         */

    }

}
