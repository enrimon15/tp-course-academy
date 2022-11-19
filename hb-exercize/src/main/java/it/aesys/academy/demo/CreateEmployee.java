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
            //creazione session factory da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            //creazione oggetto employee
            System.out.println("creazione oggetto employee");
            Employee employee = new Employee("Stephen", "Strange", "AESYS");

            //inizio transazione
            System.out.println("inizio transazione");
            session.beginTransaction();

            //salvataggio oggetto
            System.out.println("salvataggio oggetto employee");
            session.save(employee);

            //commit transazione (rendo persistenti le operazioni nel db)
            session.getTransaction().commit();
            System.out.println("commit effettuato");
        } catch (Exception e) {
            System.out.println("Errore: " + e);
            // se la sessione e la relativa transazione non sono nulle, faccio il rollback
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            // chiudo la session factory
            HibernateUtility.shutdown();
        }


    }
}
