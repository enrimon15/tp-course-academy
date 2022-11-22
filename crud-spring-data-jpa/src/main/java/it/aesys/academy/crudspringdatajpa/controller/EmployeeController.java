package it.aesys.academy.crudspringdatajpa.controller;

import it.aesys.academy.crudspringdatajpa.entity.Employee;
import it.aesys.academy.crudspringdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // get all employess
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    // get employee by id dati in input
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // creazione nuovo employee
    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // creazione nuovo employee
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        service.updateEmployeeById(id, employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        service.removeEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search") // http:// ........ /api/employees/search?email=...
    public ResponseEntity<Employee> searchByEmail(@RequestParam String email) {
        Employee employee = service.searchByEmail(email);
        return ResponseEntity.ok(employee);
    }

}
