package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UpdateEmployee {

    public static void main(String[] args) {

        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            int mockId = 1;

            // query che restituisce l'employee con il dato id
            Employee myEmployee = session.get(Employee.class, mockId);

            // update in memoria
            myEmployee.setFirstName("Enrico");

            System.out.println(" New Employee: " + myEmployee);

            //commit: update persistente
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
