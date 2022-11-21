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

	// N.B. in uno scenario reale non inietto la dipendenza del dao direttamente nel main
	// uso la catena controller <--> service <--> dao/repository (con interfacce e implementazioni)
	@Autowired
	private EmployeeDao dao;

	// metodo implementato da ApplicationRunner per eseguire codice allo startup
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Esegui codice allo startup..");
		// unidirectional
		//createEmployee();
		//deleteEmployee();

		// bidirectional
		//printEmployeeByDetailId();
		deleteEmployeeByEmployeeDetailId();
	}

	private void createEmployee(){
		// creo gli oggeti Employee e EmployeeDetail
		EmployeeDetail detail = new EmployeeDetail("324234", "tony.stark@aesys.tech", 20);
		Employee employee = new Employee("Tony", "Stark", "AESYS");
		// li compongo in un unico oggetto facendo il set dei dettagli sull'Employee
		employee.setEmployeeDetail(detail);
		// chiamo il DAO passando in input l'oggetto unico (composto)
		dao.create(employee);
	}

	private void deleteEmployee() {
		int mockId = 1;
		dao.deleteById(mockId);
	}

	private void printEmployeeByDetailId() {
		int mockDetailId = 2;
		dao.getByDetailId(mockDetailId);
	}

	private void deleteEmployeeByEmployeeDetailId() {
		int mockDetailId = 2;
		dao.deleteByEmployeeDetailId(mockDetailId);
	}
}
