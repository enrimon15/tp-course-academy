package it.aesys.academy.hbonetomany.dao;

import it.aesys.academy.hbonetomany.entity.Employee;

public interface EmployeeDao {
    void createEmployee(Employee employee);

    void printSkillsById(int mockId);
}
