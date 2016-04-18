package edu.neu.boweiwang.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kym-1992 on 3/27/16.
 */
public class DAO {

    private static final Logger log = Logger.getAnonymousLogger();

    private static final ThreadLocal sessionThread = new ThreadLocal();
//    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static final Configuration configuration = new Configuration().configure();
    private static final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    private static final SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

    protected DAO() {
    }

    public static Session getSession()
    {
        Session session = (Session) DAO.sessionThread.get();

        if (session == null)
        {
            session = sessionFactory.openSession();
            DAO.sessionThread.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        DAO.sessionThread.set(null);
    }
}
