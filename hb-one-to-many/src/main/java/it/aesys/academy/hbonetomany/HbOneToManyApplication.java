package it.aesys.academy.hbonetomany;

import it.aesys.academy.hbonetomany.dao.EmployeeDao;
import it.aesys.academy.hbonetomany.entity.Employee;
import it.aesys.academy.hbonetomany.entity.EmployeeDetail;
import it.aesys.academy.hbonetomany.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbOneToManyApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HbOneToManyApplication.class, args);
	}

	// N.B. in uno scenario reale non inietto la dipendenza del dao direttamente nel main
	// uso la catena controller <--> service <--> dao/repository (con interfacce e implementazioni)
	@Autowired
	private EmployeeDao dao;

	// metodo implementato da ApplicationRunner per eseguire codice allo startup
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Esegui codice allo startup..");
		//createEmployee();
		printEmployeeSkillsByEmployeeId();
	}

	private void createEmployee() {
		EmployeeDetail detail = new EmployeeDetail("234234", "tony.stark@aesys.tech", 20);
		Skill ia = new Skill("Intelligenza Artificiale", 10);
		Skill java = new Skill("Java", 10);

		Employee employee = new Employee("Tony", "Stark", "AESYS");

		// compongo l'oggetto con le relazioni
		employee.setEmployeeDetail(detail);
		employee.addSkill(ia);
		employee.addSkill(java);

		dao.createEmployee(employee);
	}

	private void printEmployeeSkillsByEmployeeId() {
		int mockId = 1;
		dao.printSkillsById(mockId);
	}
}
