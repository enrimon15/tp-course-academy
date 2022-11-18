package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {

        /*
        // Creazione employee con hibernate file config
        Session session = null;
		SessionFactory sessionFactory = null;
		try {

			//creazione Session factory
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class)
					.buildSessionFactory();

			//creazione sessione
			session = sessionFactory.getCurrentSession();

			//creazione oggetto
			System.out.println("creazione oggetto employee");
			Employee myemployee = new Employee("Tony", "Stark", "AESYS");

			//inizio transazione
			session.beginTransaction();

			//salvataggio oggetto
			System.out.println("salvataggio oggetto employee");
			session.save(myemployee);

			//commit
			session.getTransaction().commit();
			System.out.println("commit effettuato");

		} catch (Exception e) {
			System.out.println("Errore: " + e);
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (sessionFactory != null && sessionFactory.isOpen()) {
				sessionFactory.close();
			}
		}
         */

        // Creazione employee con hibernate java class config (esternalizzata)
        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            //creazione oggetto
            System.out.println("creazione oggetto studente");
            Employee employee = new Employee("Stephen", "Strange", "AESYS");

            //inizio transazione
            session.beginTransaction();

            //salvataggio oggetto
            System.out.println("salvataggio oggetto employee");
            session.save(employee);

            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");
        } catch (Exception e) {
            System.out.println("Errore: " + e);
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            HibernateUtility.shutdown();
        }


    }
}
