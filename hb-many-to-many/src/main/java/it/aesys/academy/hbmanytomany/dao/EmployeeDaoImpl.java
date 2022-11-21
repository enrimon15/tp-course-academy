package it.aesys.academy.hbmanytomany.dao;

import it.aesys.academy.hbmanytomany.entity.Employee;
import it.aesys.academy.hbmanytomany.entity.Project;
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
    public void createAndAssignProject(int employeeId, Project newProject) {
        Session session = sessionFactory.getCurrentSession();
        // prendo dal db l'employee con id dato
        Employee employee = session.get(Employee.class, employeeId);
        employee.addProject(newProject);
        session.save(newProject);
    }

    @Override
    public void printProjectsById(int mockEmployeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, mockEmployeeId);
        System.out.println("Progetti associati: " + employee.getProjects());
    }
}
