package it.aesys.academy.hbmanytomany;

import it.aesys.academy.hbmanytomany.dao.EmployeeDao;
import it.aesys.academy.hbmanytomany.entity.Employee;
import it.aesys.academy.hbmanytomany.entity.EmployeeDetail;
import it.aesys.academy.hbmanytomany.entity.Project;
import it.aesys.academy.hbmanytomany.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbManyToManyApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HbManyToManyApplication.class, args);
	}

	// N.B. in uno scenario reale non inietto la dipendenza del dao direttamente nel main
	// uso la catena controller <--> service <--> dao/repository (con interfacce e implementazioni)
	@Autowired
	private EmployeeDao dao;

	// metodo implementato da ApplicationRunner per eseguire codice allo startup
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Esegui codice allo startup..");
		//createAndAssignProject();
		//printProjectsByEmployeeId();
		deleteEmployeeById();
	}

	// creo progetto e lo assegno ad un employee esistente
	private void createAndAssignProject() {
		Project project = new Project(50000, "Poste Italiane", "Click and Collect");
		int employeeId = 1;
		dao.createAndAssignProject(employeeId, project);
	}

	private void printProjectsByEmployeeId() {
		int mockEmployeeId = 1;
		dao.printProjectsById(mockEmployeeId);
	}

	private void deleteEmployeeById() {
		int mockEmployeeId = 1;
		dao.deleteById(mockEmployeeId);
	}
}
