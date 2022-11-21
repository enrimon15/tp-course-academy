package it.aesys.academy.crudjpa.service;

import it.aesys.academy.crudjpa.dao.EmployeeDao;
import it.aesys.academy.crudjpa.entity.Employee;
import it.aesys.academy.crudjpa.exception.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public List<Employee> getAllEmployee() {
        return dao.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = dao.findById(id);
        if (employee == null) {
            throw new MyCustomException("Employee con id " + id + " non trovato", HttpStatus.NOT_FOUND.value());
        }
        return employee;
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        dao.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeById(int id, Employee newEmployee) {
        // utilizzo il metodo di get già creato in precedenza, che controlla anche l'esistenza sul db del record
        Employee oldEmployee = getEmployeeById(id);
        // setto gli id per aggiornare
        newEmployee.setId(oldEmployee.getId());
        newEmployee.getEmployeeDetail().setId(oldEmployee.getEmployeeDetail().getId());
        dao.saveOrUpdate(newEmployee);
    }
}
