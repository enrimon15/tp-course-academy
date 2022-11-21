package it.aesys.academy.hbonetomany.dao;

import it.aesys.academy.hbonetomany.entity.Employee;
import it.aesys.academy.hbonetomany.entity.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        System.out.println("Employee salvato: " + employee.toString());
    }

    @Override
    public void printSkillsById(int mockId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, mockId);
        System.out.println("Skills associate: " + employee.getSkills());
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int mockId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, mockId);
        session.delete(employee);
    }
}
