package it.aesys.academy.crudjpa.service;

import it.aesys.academy.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);
}
