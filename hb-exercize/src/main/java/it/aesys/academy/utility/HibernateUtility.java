package it.aesys.academy.utility;

import it.aesys.academy.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtility {

    private static SessionFactory sessionFactory = initHibernate();

    // inizializzatore per hibernate senza file
    private static SessionFactory initHibernate() {
        try {
            //creazione Session factory
            Map<String, String> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/tp_academy_db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
            settings.put(Environment.USER, "tp_academy_user");
            settings.put(Environment.PASS, "tp_academy_password");
            settings.put(Environment.POOL_SIZE, "1");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.FORMAT_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "validate");

            // wrappare i settings
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(settings).build();

            // costruire i metadati
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Employee.class);
            Metadata metadata = metadataSources.buildMetadata();

            // costruire la SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (HibernateException e) {
            System.out.println("Errore nell'inizializzazione di Hibernate: " + e);
            // rilancio un eccezione a runtime (non checked) che blocca il flusso del programma
            throw new ExceptionInInitializerError(e);
        }
    }

    // ottengo la session factory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // distruggo hibernate
    public static void shutdown() {
        // controlli sulla Session per evitare null pointer
        if (sessionFactory != null && sessionFactory.isOpen()) {
            // chiudo la sessione
            sessionFactory.close();
        }
    }
}
