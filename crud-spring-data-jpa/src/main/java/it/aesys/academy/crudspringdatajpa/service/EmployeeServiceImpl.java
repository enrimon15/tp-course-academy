package it.aesys.academy.crudspringdatajpa.service;

import it.aesys.academy.crudspringdatajpa.entity.Employee;
import it.aesys.academy.crudspringdatajpa.exception.MyCustomException;
import it.aesys.academy.crudspringdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOpt = repo.findById(id);
        if (employeeOpt.isEmpty()) {
            throw new MyCustomException("Employee con id " + id + " non trovato", HttpStatus.NOT_FOUND.value());
        }
        return employeeOpt.get();
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        repo.save(employee);
        //dao.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeById(int id, Employee newEmployee) {
        // utilizzo il metodo di get già creato in precedenza, che controlla anche l'esistenza sul db del record
        Employee oldEmployee = getEmployeeById(id);
        // setto gli id per aggiornare
        newEmployee.setId(oldEmployee.getId());
        newEmployee.getEmployeeDetail().setId(oldEmployee.getEmployeeDetail().getId());
        repo.save(newEmployee);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        Employee employeeToDelete = getEmployeeById(id);
        repo.delete(employeeToDelete);
        //repo.deleteById(id);
    }

    @Override
    public Employee searchByEmail(String email) {
        Optional<Employee> employeeOptional = repo.findByEmployeeDetailEmail(email);
        if (employeeOptional.isEmpty()) {
            throw new MyCustomException("Employee con email " + email + " non trovato", HttpStatus.NOT_FOUND.value());
        }
        return employeeOptional.get();
    }
}
