package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DocumentService {

    public Document createDocument(DocumentRequest request) throws IOException;
    public List<Document> getAllDocuments();
    public List<Document> getDocumentByCf(String cf);

    public Document getDocumentById(Integer id);

    public void deleteDocument(Integer id);

    public Document updateDocument(DocumentRequest request, Integer id) throws IOException;
}
