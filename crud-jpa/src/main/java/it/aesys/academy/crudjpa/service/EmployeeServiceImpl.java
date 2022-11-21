package it.aesys.academy.crudjpa.service;

import it.aesys.academy.crudjpa.dao.EmployeeDao;
import it.aesys.academy.crudjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public List<Employee> getAllEmployee() {
        return dao.findAll();
    }
}
