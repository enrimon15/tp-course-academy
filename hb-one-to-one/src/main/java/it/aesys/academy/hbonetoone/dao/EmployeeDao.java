package it.aesys.academy.hbonetoone.dao;

import it.aesys.academy.hbonetoone.entity.Employee;

public interface EmployeeDao {
    public void create(Employee employee);
    public void deleteById(int id);

    void getByDetailId(int mockDetailId);

    void deleteByEmployeeDetailId(int mockDetailId);
}
