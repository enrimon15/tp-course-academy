package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FindEmployee {

    public static void main(String[] args) {

        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            //creazione oggetto
            System.out.println("get oggetto studente");

            //inizio transazione
            session.beginTransaction();

            int mockId = 1;

            Employee employee = session.get(Employee.class, mockId);

            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

            System.out.println("Employee: " + employee.toString());
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
