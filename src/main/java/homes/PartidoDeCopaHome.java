package homes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.BasicTransformerAdapter;

import commands.HibernateManager;

import dominio.Equipo;
import dominio.PartidoDeCopa;

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
        
        /* Criteria criteria = session.createCriteria(PartidoDeCopa.class);
        final ProjectionList proyecciones = Projections.projectionList();
        proyecciones.add(Projections.count("ganadorP"), "ganados");
        proyecciones.add(Projections.groupProperty("ganadorP"));
        criteria.setProjection(proyecciones);
        criteria.addOrder(Order.desc("ganados"));
        return criteria.list();
        */
        

        Query query = session
        .createQuery("select pc.ganadorP from PartidoDeCopa as pc group by pc.ganadorP order by count(*) asc");
        

        List<Equipo> equipos = new ArrayList<Equipo>();

        for (Object[] r : (List<Object[]>) query.list()) {
            equipos.add((Equipo) r[0]);
        }

        return equipos;

        /*
         * criteria.add(geProperty("golesEquipoA", "golesEquipoB")); return criteria.list().size();
         */

    }
    
    public int cantidadDePartidosDeCopaGanadosPor(Equipo eq){
        Session session = HibernateManager.instance().getSession();

        Query query = session
        .createQuery("from PartidoDeCopa as pc where (pc.ganadorP.nombre = ?)");
        query.setString(0, eq.getNombre());
        
        return query.list().size();
    }
    
    public void save(PartidoDeCopa pc){
		Session session = HibernateManager.instance().getSession();
		
		session.saveOrUpdate(pc);		
		
	}
    
}
