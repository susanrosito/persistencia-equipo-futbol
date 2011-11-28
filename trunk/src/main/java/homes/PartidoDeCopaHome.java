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
    
    public void save(PartidoDeCopa pc){
		Session session = HibernateManager.instance().getSession();
		
		session.saveOrUpdate(pc);		
		
	}
    
}
