package Tests;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import Clases.Equipo;

public class ConfigurationTest extends TestCase {
    @SuppressWarnings({ "unused", "deprecation" })
    public void testApp() throws Exception {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction;
        transaction = session.beginTransaction();
        session.beginTransaction();
        try {
            // for (int i = 0; i < 1000; i++) {
            // Jugador j = new Jugador("UnNombre" + i, "UnApellido", i);
            // session.saveOrUpdate(j);
            // }

            // session.load(Equipo.class, 1);
            // session.load(Tecnico.class, 1);

            // Tecnico t = new Tecnico();
            // t.setNombre("dsdsdsds");

            Equipo e = (Equipo) session.load(Equipo.class, 1);
            e.setNombre("habla");
            e.setNombre("hable");
            e.setNombre("hablo");
            e.setNombre("habli");
            e.setNombre("habla");

            // Equipo e = new Equipo();
            // e.setNombre("lerolero");
            // e.setTecnico(t);

            // session.saveOrUpdate(e);
            // session.saveOrUpdate(t);

            // Criteria criteria = session.createCriteria(Equipo.class);
            // criteria.add(Expression.eq("nroCamiseta", 60));
            // criteria.add(Expression.eq("apellido", "UnApellido"));
            // List<Jugador> list = criteria.list();
            // System.out.println(criteria.uniqueResult());

            // for (Jugador jugador : list) {
            // System.out.println(jugador);
            // }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
