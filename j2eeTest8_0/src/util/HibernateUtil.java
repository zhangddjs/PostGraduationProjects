package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static{
		Configuration cf = new Configuration();
		cf.configure();
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cf.getProperties()).build();
		sessionFactory = cf.buildSessionFactory(sr);
	}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
