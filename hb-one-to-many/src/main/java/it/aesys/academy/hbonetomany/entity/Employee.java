package it.aesys.academy.hbonetomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skill> skills;

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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skillToAdd) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skillToAdd);
        // setto la relazione biderezionale (perchè l'owner è su skill)
        // this si riferisce all'oggetto employee corrente
        skillToAdd.setEmployee(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", employeeDetail=" + employeeDetail +
                ", skills=" + skills +
                '}';
    }
}

