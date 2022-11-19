package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeleteEmployee {

    public static void main(String[] args) {

        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            // inizio transazione
            Transaction tx = session.beginTransaction();

            int mockId = 1;
            // mi prendo dal db l'employee con id specificato
            Employee employee = session.get(Employee.class, mockId);
            session.delete(employee);

            // commit transazione (rendo persistenti le operazioni nel db)
            tx.commit();
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
