package it.aesys.academy.crudspringdatajpa.service;

import it.aesys.academy.crudspringdatajpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    void createEmployee(Employee employee);

    void updateEmployeeById(int id, Employee employee);

    void removeEmployee(int id);

    Employee searchByEmail(String email);
}
