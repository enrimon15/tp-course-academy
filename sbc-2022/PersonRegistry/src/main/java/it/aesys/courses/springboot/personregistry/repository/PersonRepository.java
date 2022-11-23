package it.aesys.courses.springboot.personregistry.repository;

import it.aesys.courses.springboot.personregistry.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
