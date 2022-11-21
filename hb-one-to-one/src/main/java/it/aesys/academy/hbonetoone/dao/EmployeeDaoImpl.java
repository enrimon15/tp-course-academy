package it.aesys.academy.hbonetoone.dao;

import it.aesys.academy.hbonetoone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        // salvo l'Employee e a cascata anche l'entità correlata EmployeeDetail (grazie all'attributo cascade specificato nel mapping)
        session.save(employee);
        System.out.println("Employee salvato: " + employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        // Ottengo l'employee tramite id dato in input
        Employee employeeToDelete = session.get(Employee.class, id);
        // elimino l'Employee e a cascata anche l'entità correlata EmployeeDetail (grazie all'attributo cascade specificato nel mapping)
        session.delete(employeeToDelete);
    }
}
