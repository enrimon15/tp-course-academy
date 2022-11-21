package it.aesys.academy.crudjpa.dao;

import it.aesys.academy.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int id);

    void saveOrUpdate(Employee employee);

    void remove(Employee employeeToDelete);

    Employee searchByEmail(String email);
}
