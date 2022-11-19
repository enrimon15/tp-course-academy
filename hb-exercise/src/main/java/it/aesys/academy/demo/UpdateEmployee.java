package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateEmployee {

    public static void main(String[] args) {

        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            // inizio transazione
            session.beginTransaction();

            int mockId = 1;
            // query che restituisce l'employee con l'id specificato
            Employee myEmployee = session.get(Employee.class, mockId);

            // update in memoria
            myEmployee.setFirstName("Enrico");
            System.out.println("Employee aggiornato: " + myEmployee);

            // commit transazione (rendo persistenti le modifiche nel db)
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
