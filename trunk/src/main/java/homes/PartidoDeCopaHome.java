package homes;

import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.geProperty;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;

import commands.HibernateManager;

import dominio.PartidoDeCopa;

public class PartidoDeCopaHome {

    public int getCantPartidosDeCopaGanadosPor(final String nombre) {
        Session session = HibernateManager.instance().getSession();
        Criteria criteria = session.createCriteria(PartidoDeCopa.class);

        Criteria criteriaEquipoLocal = criteria.createCriteria("ganadorP");
        criteriaEquipoLocal.add(eq("nombre", nombre));

        criteria.add(geProperty("golesEquipoA", "golesEquipoB"));
        return criteria.list().size();

    }

}
