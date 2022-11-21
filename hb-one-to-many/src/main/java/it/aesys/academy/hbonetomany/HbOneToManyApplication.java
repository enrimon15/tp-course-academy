package it.aesys.academy.hbonetomany;

import it.aesys.academy.hbonetomany.dao.EmployeeDao;
import it.aesys.academy.hbonetomany.entity.Employee;
import it.aesys.academy.hbonetomany.entity.EmployeeDetail;
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

	}
}
