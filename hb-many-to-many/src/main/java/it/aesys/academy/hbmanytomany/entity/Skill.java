package it.aesys.academy.hbmanytomany.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private int level;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Skill() {}

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
