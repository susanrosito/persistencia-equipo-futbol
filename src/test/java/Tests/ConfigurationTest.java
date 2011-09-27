package Tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import Clases.Equipo;
import Clases.FormacionStrategyImp;
import Clases.HabilidadImp;
import Clases.Jugador;
import Clases.PartidoSimple;
import Clases.Posicion;
import Clases.Tecnico;

public class ConfigurationTest extends TestCase {
    @SuppressWarnings({ "unused", "deprecation" })
    public void testApp() throws Exception {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory(); // Esta es nuestra session
        Session session = sessionFactory.openSession(); // aca se abre la session.

        org.hibernate.Transaction transaction; // definimos la transaccion
        transaction = session.beginTransaction(); // Comienza la transaccion
        session.beginTransaction();
        try {
            // Ejemplo: ingresar 1001 jugadores en la tabla jugador
            // for (int i = 0; i < 1000; i++) {
            // Jugador j = new Jugador("UnNombre" + i, "UnApellido", i);
            // session.saveOrUpdate(j); // aca manda la orden a guardar
            // }

            // session.load(Equipo.class, 1);
            // session.load(Tecnico.class, 1);

            // Tecnico t = new Tecnico();
            // t.setNombre("dsdsdsds");

            Equipo e = (Equipo) session.load(Equipo.class, 1);
            // session.createQuery("DELETE FROM Jugador").executeUpdate();

            // e.setNombre("habla");
            // e.setNombre("hable");

            Jugador j = new Jugador();
            j.setNombre("Jorge");
            HabilidadImp a = new HabilidadImp();
            a.setPosicion(Posicion.ARQUERO);
            a.setValor(10);
            j.setHabilidad(a, 1);

            Jugador j1 = new Jugador();
            j1.setNombre("Cleto");
            HabilidadImp a1 = new HabilidadImp();
            a1.setPosicion(Posicion.CENTRAL);
            a1.setValor(10);
            j1.setHabilidad(a1, 1);

            Jugador j2 = new Jugador();
            j2.setNombre("Manuel");
            HabilidadImp a2 = new HabilidadImp();
            a2.setPosicion(Posicion.DELANTERO);
            a2.setValor(10);
            j2.setHabilidad(a2, 1);

            Jugador j3 = new Jugador();
            j3.setNombre("Mickey");
            HabilidadImp a3 = new HabilidadImp();
            a3.setPosicion(Posicion.ENGANCHE);
            a3.setValor(10);
            j3.setHabilidad(a3, 1);

            Jugador j4 = new Jugador();
            j4.setNombre("Goofy");
            HabilidadImp a4 = new HabilidadImp();
            a4.setPosicion(Posicion.LATERAL);
            a4.setValor(10);
            j4.setHabilidad(a4, 1);

            Jugador j5 = new Jugador();
            j5.setNombre("Kitty");
            HabilidadImp a5 = new HabilidadImp();
            a5.setPosicion(Posicion.MEDIA_PUNTA);
            a5.setValor(10);
            j5.setHabilidad(a5, 1);

            Jugador j6 = new Jugador();
            j6.setNombre("Osvaldo");
            HabilidadImp a6 = new HabilidadImp();
            a6.setPosicion(Posicion.VOLANTE_DEFENSIVO);
            a6.setValor(10);
            j6.setHabilidad(a6, 1);

            Jugador j7 = new Jugador();
            j7.setNombre("Domingo");
            HabilidadImp a7 = new HabilidadImp();
            a7.setPosicion(Posicion.VOLANTE_LATERAL);
            a7.setValor(10);
            j7.setHabilidad(a7, 1);

            Jugador j8 = new Jugador();
            j8.setNombre("Roberto");
            HabilidadImp a8 = new HabilidadImp();
            a8.setPosicion(Posicion.ARQUERO);
            a8.setValor(7);
            j8.setHabilidad(a8, 1);

            Jugador j9 = new Jugador();
            j9.setNombre("Josele");
            HabilidadImp a9 = new HabilidadImp();
            a9.setPosicion(Posicion.CENTRAL);
            a9.setValor(7);
            j9.setHabilidad(a9, 1);

            Jugador j10 = new Jugador();
            j10.setNombre("Josue");
            HabilidadImp a10 = new HabilidadImp();
            a10.setPosicion(Posicion.DELANTERO);
            a10.setValor(7);
            j10.setHabilidad(a10, 1);

            Jugador ja = new Jugador();
            ja.setNombre("Jorge II");
            HabilidadImp aa = new HabilidadImp();
            aa.setPosicion(Posicion.ARQUERO);
            aa.setValor(10);
            ja.setHabilidad(aa, 1);

            Jugador j1a = new Jugador();
            j1a.setNombre("Cleto II");
            HabilidadImp a1a = new HabilidadImp();
            a1a.setPosicion(Posicion.CENTRAL);
            a1a.setValor(10);
            j1a.setHabilidad(a1a, 1);

            Jugador j2a = new Jugador();
            j2a.setNombre("Manuel II");
            HabilidadImp a2a = new HabilidadImp();
            a2a.setPosicion(Posicion.DELANTERO);
            a2a.setValor(10);
            j2a.setHabilidad(a2a, 1);

            Jugador j3a = new Jugador();
            j3a.setNombre("Mickey II");
            HabilidadImp a3a = new HabilidadImp();
            a3a.setPosicion(Posicion.ENGANCHE);
            a3a.setValor(10);
            j3a.setHabilidad(a3a, 1);

            Jugador j4a = new Jugador();
            j4a.setNombre("Goofy II");
            HabilidadImp a4a = new HabilidadImp();
            a4a.setPosicion(Posicion.LATERAL);
            a4a.setValor(10);
            j4a.setHabilidad(a4a, 1);

            Jugador j5a = new Jugador();
            j5a.setNombre("Kitty II");
            HabilidadImp a5a = new HabilidadImp();
            a5a.setPosicion(Posicion.MEDIA_PUNTA);
            a5a.setValor(10);
            j5a.setHabilidad(a5a, 1);

            Jugador j6a = new Jugador();
            j6a.setNombre("Osvaldo II");
            HabilidadImp a6a = new HabilidadImp();
            a6a.setPosicion(Posicion.VOLANTE_DEFENSIVO);
            a6a.setValor(10);
            j6a.setHabilidad(a6a, 1);

            Jugador j7a = new Jugador();
            j7a.setNombre("Domingo II");
            HabilidadImp a7a = new HabilidadImp();
            a7a.setPosicion(Posicion.VOLANTE_LATERAL);
            a7a.setValor(10);
            j7a.setHabilidad(a7a, 1);

            Jugador j8a = new Jugador();
            j8a.setNombre("Roberto II");
            HabilidadImp a8a = new HabilidadImp();
            a8a.setPosicion(Posicion.ARQUERO);
            a8a.setValor(7);
            j8a.setHabilidad(a8a, 1);

            Jugador j9a = new Jugador();
            j9a.setNombre("Josele II");
            HabilidadImp a9a = new HabilidadImp();
            a9a.setPosicion(Posicion.CENTRAL);
            a9a.setValor(7);
            j9a.setHabilidad(a9a, 1);

            Jugador j10a = new Jugador();
            j10a.setNombre("Josue II");
            HabilidadImp a10a = new HabilidadImp();
            a10a.setPosicion(Posicion.DELANTERO);
            a10a.setValor(7);
            j10a.setHabilidad(a10a, 1);

            ArrayList<Jugador> juga = new ArrayList<Jugador>();
            juga.add(j10a);
            juga.add(j9a);
            juga.add(j8a);
            juga.add(j7a);
            juga.add(j6a);
            juga.add(j5a);
            juga.add(j4a);
            juga.add(j3a);
            juga.add(j2a);
            juga.add(j1a);
            juga.add(ja);

            ArrayList<Jugador> juga2 = new ArrayList<Jugador>();
            juga2.add(j10);
            juga2.add(j9);
            juga2.add(j8);
            juga2.add(j7);
            juga2.add(j6);
            juga2.add(j5);
            juga2.add(j4);
            juga2.add(j3);
            juga2.add(j2);
            juga2.add(j1);
            juga2.add(j);

            ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
            posiciones.add(Posicion.ARQUERO);
            posiciones.add(Posicion.CENTRAL);
            posiciones.add(Posicion.DELANTERO);
            posiciones.add(Posicion.ENGANCHE);
            posiciones.add(Posicion.LATERAL);
            posiciones.add(Posicion.MEDIA_PUNTA);
            posiciones.add(Posicion.VOLANTE_DEFENSIVO);
            posiciones.add(Posicion.VOLANTE_LATERAL);

            Tecnico ta = new Tecnico();
            ta.setNombre("Anastacio");
            ta.setFormacionStrategy(new FormacionStrategyImp(posiciones));

            Tecnico tb = new Tecnico();
            tb.setNombre("Crustacio");
            tb.setFormacionStrategy(new FormacionStrategyImp(posiciones));

            Equipo eqa = new Equipo();
            eqa.setJugadores(juga);
            eqa.setNombre("Equipo A");
            eqa.setTecnico(ta);

            Equipo eqb = new Equipo();
            eqb.setJugadores(juga2);
            eqb.setNombre("Equipo B");
            eqb.setTecnico(tb);

            PartidoSimple p = new PartidoSimple();
            p.setEquipoA(eqa);
            p.setEquipoB(eqb);

            // PartidoDeCopa pc = new PartidoDeCopa();
            // pc.setEquipoA(eqa);
            // pc.setEquipoB(eqb);
            // pc.s

            // HabilidadImp h1 = new HabilidadImp();
            // h1.setPosicion(Posicion.ENGANCHE);
            // HabilidadImp h2 = new HabilidadImp();
            // h2.setPosicion(Posicion.ARQUERO);
            // j.getHabilidades().add(h1);
            // j.getHabilidades().add(h2);

            session.saveOrUpdate(p);

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
