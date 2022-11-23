package it.aesys.courses.springboot.repository;

import it.aesys.courses.springboot.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

    // custom
    List<Document> findByFiscalCode(String fiscalCode);
}
