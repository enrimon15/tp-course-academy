package it.aesys.academy.hbonetoone.entity;

import javax.persistence.*;

@Entity
@Table(name ="employee")
public class Employee {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="company")
    private String company;

    // cascade: https://www.baeldung.com/jpa-cascade-types
    // le operazioni specificate nel cascade, su questa entity, vengono riflesse a cascata sulle entities correlate
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "employee_detail_id")
    private EmployeeDetail employeeDetail;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String company) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String email) {
        this.company = email;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", employeeDetail=" + employeeDetail +
                '}';
    }
}

