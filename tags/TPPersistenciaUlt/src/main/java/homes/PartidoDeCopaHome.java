package homes;

import java.util.ArrayList;
import java.util.Iterator;
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
import dominio.PartidoSimple;

public class PartidoDeCopaHome {
   
    public int cantidadDePartidosDeCopaGanadosPor(Equipo eq){
    	int cantPCG = 0;
    	ArrayList<PartidoDeCopa> partsDeCopa = this.getPartidosDeCopa();
    	for(PartidoDeCopa pc : partsDeCopa){
    		if(pc.getGanadorP().getNombre() == eq.getNombre()){
    			cantPCG = cantPCG + 1;
    		}
    	}
    	return cantPCG;
    }
    
    public ArrayList<PartidoDeCopa> getPartidosDeCopa(){
    	Session session = HibernateManager.instance().getSession();
    	
    	Query q = session.createQuery("from PartidoDeCopa");
        return (ArrayList<PartidoDeCopa>) q.list();
    }
    
    /**
     * Consulta que muestra la lista de los equipos que tienen mayor cantidad de victorias de copa
     * optimisando la consulta al agregar una columna en la tabla de equipos que por cada uno lleva la 
     * cuenta de cuántos partidos de copa ganó.
     * @return
     */
    
    public List<Object[]> getPartidosDeCopaGanadosPorEquipoPerformante() {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("select eq.nombre, eq.cantPartidosDeCopaGanados from Equipo as eq order by eq.cantPartidosDeCopaGanados desc");
        
        
        return query.list();
    }
    
    
    public void save(PartidoDeCopa pc){
		Session session = HibernateManager.instance().getSession();
		
		session.saveOrUpdate(pc);		
		
	}
    
}
