package homes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;

import commands.HibernateManager;

import dominio.Equipo;


/**
 * TODO: description
 */

public class EquipoHome {
	
//	public static final String BOCA = "Boca";
//	public static final String RIVER = "River";
//	public static final String SANLORENZO = "San Lorenzo";
//	public static final String LANUS = "Lanus";
//	public static final String INDEPENDIENTE = "Independiente";
//	public static final String RACING = "Racing";
//	public static final String VELEZ = "Velez";
//	public static final String GIMNACIA = "Gimnacia";
//	public static final String ESTUDIANTES = "Estudiantes";
//	public static final String GODOYCRUZ = "Godoy Cruz";
//	public static final String QUILMES = "Quilmes";
//	public static final String BERAZATEGUI = "Berazategui";
	
	
	public Equipo getByName(final String nombre) {
		   Session session = HibernateManager.instance().getSession();
        Criteria criteria = session.createCriteria(Equipo.class);
        criteria.add(Expression.eq("nombre", nombre));
        return (Equipo) criteria.uniqueResult();
    }

	public void setNEquipos(List<Equipo> equipo){
		Session session = HibernateManager.instance().getSession();
		for (Equipo equipoActual : equipo) {
			session.saveOrUpdate(equipoActual);
		}
		
	}
}
