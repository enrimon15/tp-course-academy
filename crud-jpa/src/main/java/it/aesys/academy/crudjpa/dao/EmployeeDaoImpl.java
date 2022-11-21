package it.aesys.academy.crudjpa.dao;

import it.aesys.academy.crudjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        // se l'id == null oppure è 0 --> salva su db, altrimenti aggiorna
        entityManager.merge(employee);
    }
}
