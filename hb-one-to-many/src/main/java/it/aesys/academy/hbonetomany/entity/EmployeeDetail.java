package it.aesys.academy.hbonetomany.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_detail")
public class EmployeeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="phone")
    private String phone;

    @Column(name ="email", nullable = false, unique = true)
    private String email;

    @Column(name ="year_experience")
    private int yearExperience;

    @OneToOne(mappedBy = "employeeDetail", cascade = CascadeType.ALL)
    private Employee employee;

    public EmployeeDetail() {}

    public EmployeeDetail(String phone, String email, int yearExperience) {
        this.phone = phone;
        this.email = email;
        this.yearExperience = yearExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // non metto nel toString l'employee altrimenti ho un ciclo infinito
    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", yearExperience=" + yearExperience +
                '}';
    }
}
