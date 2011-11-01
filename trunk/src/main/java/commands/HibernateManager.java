package commands;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * TODO: description
 */
public class HibernateManager {

    private static HibernateManager inst = new HibernateManager();

    private final SessionFactory sessionFactory;

    private ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    public HibernateManager() {
        Configuration cfg = new Configuration();
        cfg.configure();
        this.sessionFactory = cfg.buildSessionFactory();
    }

    public static HibernateManager instance() {
        return inst;
    }

    public void runInSession(final Runnable bloque) {
        Session session = this.sessionFactory.openSession(); // aca se abre la session.

        this.sessionThreadLocal.set(session);

        Transaction transaction; // definimos la transaccion
        transaction = session.beginTransaction(); // Comienza la transaccion
        session.beginTransaction();

        try {
            bloque.run();
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
            this.sessionThreadLocal.set(null);
        }
    }

    public Session getSession() {
        return this.sessionThreadLocal.get();
    }
}
