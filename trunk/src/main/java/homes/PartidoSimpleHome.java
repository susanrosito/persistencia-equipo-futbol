package homes;

import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.geProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import commands.HibernateManager;

import dominio.Equipo;
import dominio.Formacion;
import dominio.PartidoDeCopa;
import dominio.PartidoSimple;


/**
 * TODO: description
 */
public class PartidoSimpleHome {

    public int getCantPartidosSimplesLocalesGanadosPor(final String nombre, final String nombre2) {
        Session session = HibernateManager.instance().getSession();
        
       // Criteria criteria = session.createCriteria(PartidoSimple.class);

        //Criteria criteriaEquipoA = criteria.createCriteria("equipoA");
        //criteriaEquipoA.add(eq("nombre", nombre));

        //Criteria criteriaEquipoB = criteria.createCriteria("equipoB");
        //criteriaEquipoB.add(eq("nombre", nombre));

        //criteria.add(geProperty("golesEquipoA", "golesEquipoB"));
        //return criteria.list().size();
        
         Query query = session .createQuery(
         "from PartidoSimple as ps where ps.equipoA.nombre = ? and ps.equipoB.nombre = ? and ps.golesEquipoA > ps.golesEquipoB "
         ); query.setString(0, nombre); query.setString(1, nombre2); return query.list().size();
        
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
    
    /**
     * Consulta que muestra la lista de los equipos que tienen mayor cantidad de victorias de copa
     * optimisando la consulta al agregar una columna en la tabla de equipos que por cada uno lleva la 
     * cuenta de cuántos partidos de copa ganó.
     * @return
     */
    
    public List<Object[]> getPartidosDeCopaGanadosPorEquipoPerformante() {
        Session session = HibernateManager.instance().getSession();
        Query query = session
                .createQuery("select eq.nombre, eq.cantPartidosDeCopaGanados from Equipo as eq order by desc");
        
        Iterator it = query.iterate();
        while(it.hasNext()){
        	ArrayList<?> l = (ArrayList<?>) it.next();
        	System.out.println("El equipo: " + l.get(0) + "tiene " + l.get(1) + "victorias de copa");
        }
        
        return query.list();
    }
    
    public ArrayList<PartidoSimple> getPartidosSimples(){
        Session session = HibernateManager.instance().getSession();
        Query q = session.createQuery("from PartidoSimple");
        return (ArrayList<PartidoSimple>) q.list();
    }
    
    public void save(PartidoSimple ps){
		Session session = HibernateManager.instance().getSession();
		
		session.saveOrUpdate(ps);		
		
	}
    
    
    /////////////////////////////////////////////////////
    
    /*public int cantidadDePartidosDeCopaGanadosPor(Equipo eq){
    	int cantPCG = 0;
    	ArrayList<PartidoDeCopa> partsDeCopa = new PartidoDeCopaHome().getPartidosDeCopa();
    	for(PartidoDeCopa pc : partsDeCopa){
    		if(pc.getGanadorP().getNombre() == eq.getNombre()){
    			cantPCG = cantPCG + 1;
    		}
    	}
    	return cantPCG;
    }
    
    public void devolverLaLista(){
    	SortedMap listaEqCantPCG = new TreeMap();
    	ArrayList<Equipo> equipos = new EquipoHome().getEquipos();
    	for(Equipo eq: equipos){
    		listaEqCantPCG.put(eq.getNombre(), new PartidoSimpleHome().cantidadDePartidosDeCopaGanadosPor(eq));
    	}
    	
    	for( Iterator it = listaEqCantPCG.keySet().iterator(); it.hasNext();) { 

    	    // Nótese que el orden del TreeMap refleja un orden descendente.
                String eq = (String)it.next();
                Integer cantPC = (Integer)listaEqCantPCG.get(eq);
    	    System.out.println(eq + ": ha ganado " + cantPC + "partidos de copa");
    	}
    	
    }*/
    
    
    
    
}




