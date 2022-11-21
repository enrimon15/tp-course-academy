package it.aesys.academy.hbmanytomany.dao;

import it.aesys.academy.hbmanytomany.entity.Employee;
import it.aesys.academy.hbmanytomany.entity.Project;

public interface EmployeeDao {

    void createAndAssignProject(int employeeId, Project project);

    void printProjectsById(int mockEmployeeId);

    void deleteById(int mockEmployeeId);
}
