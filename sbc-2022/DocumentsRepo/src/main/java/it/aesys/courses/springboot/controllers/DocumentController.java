package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.services.DocumentService;
import it.aesys.courses.springboot.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    DocumentService service;
    FileUtil fileUtil;

    @Autowired
    public DocumentController(DocumentService service, FileUtil fileUtil) {
        this.service = service;
        this.fileUtil = fileUtil;
    }

    @GetMapping("/{id}")
    public Document findDocument(@PathVariable Integer id) {
        return service.getDocumentById(id);
    }
    @GetMapping
    public List<Document> findDocuments(@RequestParam(required = false) String cf) {
        if (cf!=null) {
            return service.getDocumentByCf(cf);
        } return service.getAllDocuments();
    }

    @PostMapping(consumes = "multipart/form-data")
    public Document createDocument(@ModelAttribute DocumentRequest request) throws IOException {
        return service.createDocument(request);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Integer id) throws SQLException {
        service.deleteDocument(id);
    }

    @PutMapping(value = "/{id}")
    public Document updateDocument(@ModelAttribute DocumentRequest request, @PathVariable Integer id) throws IOException, SQLException {
        return service.updateDocument(request, id);
    }
}


