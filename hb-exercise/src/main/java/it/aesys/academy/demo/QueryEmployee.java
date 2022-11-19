package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import it.aesys.academy.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        Session session = null;
        try {
            //creazione sessione da una classe esternalizzata (senza configurazione xml)
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            // inizio transazione
            session.beginTransaction();

            System.out.println("Prendi tutti gli employee presenti nel db");
            Query query = session.createQuery("from Employee");
            List<Employee> employeeList = query.getResultList();
            // oppure tutto su una riga List<Employee> employeeList = session.createQuery("from Employee").getResultList();
            displayEmployees(employeeList);

            System.out.println("Prendi tutti gli employee con nome Elon");
            List<Employee> employeesWithName = session.createQuery("from Employee e where e.firstName = 'Elon'").getResultList();
            displayEmployees(employeesWithName);

            System.out.println("Prendi tutti gli employee con company AESYS");
            List<Employee> employeesWithCompany = session.createQuery("from Employee e where e.company = 'AESYS'").getResultList();
            displayEmployees(employeesWithCompany);

            // commit transazione (rendo persistenti le operazioni nel db)
            session.getTransaction().commit();

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

    // metodo che data una lista di Employee in input li cicla e li stampa uno per uno
    public static void displayEmployees(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("Employee: " + employee);
        }
    }
}
