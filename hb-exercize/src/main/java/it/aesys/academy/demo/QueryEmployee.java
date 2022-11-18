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

            session.beginTransaction();

            System.out.println("Prendi tutti gli employee");
            Query query = session.createQuery("from Employee");
            List<Employee> employeeList = query.getResultList();

            //List<Employee> employeeList = session.createQuery("from Employee").getResultList();

            for (Employee employee : employeeList) {
                System.out.println("Employee: " + employee);
            }

            session.getTransaction().commit();

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
