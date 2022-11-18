package it.aesys.academy.demo;

import it.aesys.academy.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            session = sessionFactory.getCurrentSession();

            System.out.println("Creazione oggetto employee");
            Employee employee = new Employee("Tony", "Stark", "AESYS");

            System.out.println("Inizio transazione");
            session.beginTransaction();

            System.out.println("Store nel db");
            session.save(employee);

            System.out.println("Commit transazione");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Errore: " + e);
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (sessionFactory != null && sessionFactory.isOpen()) {
                sessionFactory.close();
            }
        }


    }
}
