package it.aesys.academy.hbmanytomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "budget")
    private int budget;

    @Column(name = "client")
    private String client;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "projects")
    List<Employee> employees = new ArrayList<>();

    public Project() {}

    public Project(int budget, String client, String title) {
        this.budget = budget;
        this.client = client;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", budget=" + budget +
                ", client='" + client + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
