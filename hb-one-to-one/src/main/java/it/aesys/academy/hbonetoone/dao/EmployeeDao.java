package it.aesys.academy.hbonetoone.dao;

import it.aesys.academy.hbonetoone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        System.out.println("Employee: " + employee);
    }

    @Transactional
    public void deleteById(int mockId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employeeToDelete = session.get(Employee.class, mockId);
        session.delete(employeeToDelete);
    }
}
