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
            displayEmployees(employeeList);

            System.out.println("Prendi tutti gli employee con nome Elon");

            List<Employee> employeesWithName = session.createQuery("from Employee e where e.firstName = 'Elon'").getResultList();
            displayEmployees(employeesWithName);

            System.out.println("Prendi tutti gli employee con company Aesys");

            List<Employee> employeesWithCompany = session.createQuery("from Employee e where e.company = 'AESYS'").getResultList();
            displayEmployees(employeesWithCompany);

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

    public static void displayEmployees(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("Employee: " + employee);
        }
    }
}
