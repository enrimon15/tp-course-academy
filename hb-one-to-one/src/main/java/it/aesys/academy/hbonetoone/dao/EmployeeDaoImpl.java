package it.aesys.academy.hbonetoone.dao;

import it.aesys.academy.hbonetoone.entity.Employee;
import it.aesys.academy.hbonetoone.entity.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
// transactional read only posso metterla a lv. di classe e verrà presa da ogni metodo all'interno della classe
// N.B. per i metodi di scrittura devo sovrascrivere
@Transactional
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

    @Override
    @Transactional(readOnly = true) // read only su operazioni di get (che non scrivono nel db)
    public void getByDetailId(int mockDetailId) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeDetail employeeDetail = session.get(EmployeeDetail.class, mockDetailId);
        System.out.println("Employee associato: " + employeeDetail.getEmployee());
    }

    @Override
    @Transactional
    public void deleteByEmployeeDetailId(int mockDetailId) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeDetail employeeDetail = session.get(EmployeeDetail.class, mockDetailId);
        session.delete(employeeDetail);

        // oppure
        /*Query query = session.createQuery("delete from Employee e where e.employeeDetail.id = :detailId");
        query.setParameter("detailId", mockDetailId);
        query.executeUpdate();*/
    }
}
