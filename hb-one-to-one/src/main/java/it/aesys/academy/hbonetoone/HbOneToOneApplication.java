package it.aesys.academy.hbonetoone;

import it.aesys.academy.hbonetoone.dao.EmployeeDao;
import it.aesys.academy.hbonetoone.entity.Employee;
import it.aesys.academy.hbonetoone.entity.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbOneToOneApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HbOneToOneApplication.class, args);
	}

	@Autowired
	private EmployeeDao dao;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Execute code on startup..");
		//createEmployee();
		deleteEmployee();
	}

	private void deleteEmployee() {
		int mockId = 1;
		dao.deleteById(mockId);
	}

	private void createEmployee(){
		EmployeeDetail detail = new EmployeeDetail("324234", "tony.stark@aesys.tech", 20);
		Employee employee = new Employee("Tony", "Stark", "AESYS");

		employee.setEmployeeDetail(detail);

		dao.create(employee);
	}
}
