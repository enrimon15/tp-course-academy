package it.aesys.academy.crudspringdatajpa.entity;

import javax.persistence.*;

@Entity
public class Employee {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="first_name", nullable = false)
	private String firstName;
	
	@Column(name ="last_name", nullable = false)
	private String lastName;

	@Column(name ="company", nullable = false)
	private String company;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn (name="employee_detail_id")
	private EmployeeDetail employeeDetail;
	
	public Employee(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public Employee() {}

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

	public void setCompany(String company) {
		this.company = company;
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
