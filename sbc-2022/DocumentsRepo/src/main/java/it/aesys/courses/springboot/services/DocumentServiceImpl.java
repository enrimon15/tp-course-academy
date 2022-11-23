package it.aesys.courses.springboot.services;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.exception.NotFoundException;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.repository.DocumentRepository;
import it.aesys.courses.springboot.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService{
    DocumentRepository documentRepository;
    FileUtil fileUtil;

    @Autowired
    public DocumentServiceImpl(FileUtil fileUtil, DocumentRepository documentRepository) {
        this.fileUtil = fileUtil;
        this.documentRepository = documentRepository;
    }


    // non ho più le eccezioni del DAO
    // se volessi controllare le eccezioni relative ad operazioni sul db con Spring Data JPA posso controllare la DataAccessException che wrappa tutte le eccezioni ottenibili a lv. database
    // le eccezioni le devo sempre controllare o con handler globali o con try/catch o rilanciandole, ma nel caso in cui le rilancio ad un certo punto del codice devo fare il controllo altrimenti non ha senso rilanciarle

    @Override
    @Transactional
    public Document createDocument(DocumentRequest request) throws IOException {
        if (validRequest(request)) {
            Document document = new Document();
            BeanUtils.copyProperties(request, document);
            document.setDataOfInput(LocalDate.now());
            document.setFile(fileUtil.upload(request.getFile()));
            return documentRepository.save(document);
        }
        throw new InvalidInputException("All fields are required");
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getDocumentByCf(String cf) {
        if (cf.length() == 16) {
            return documentRepository.findByFiscalCode(cf);
        }
        throw new InvalidInputException("Invalid cf");
    }

    @Override
    public Document getDocumentById(Integer id) {
        if (id != null) {
            // la findById torna in output l'optional
            // .isPresent = true se esiste, .isEmpty = true se NON esiste, .get() torna l'oggetto dopo aver fatto i controlli
            Optional<Document> documentOptional = documentRepository.findById(id);
            if (documentOptional.isEmpty()) {
                throw new NotFoundException("Document with id: " + id + " not found");
            }
            return documentOptional.get();
        }
        throw new InvalidInputException("Invalid id");
    }

    @Override
    @Transactional
    public void deleteDocument(Integer id) {
        // chiamo il metodo già implementato nel service che torna un Document dopo averne controllato l'esistenza sul db (in caso negativo lancia un'eccezione)
        Document documentToDelete = this.getDocumentById(id);
        documentRepository.delete(documentToDelete);
    }

    @Override
    @Transactional
    public Document updateDocument(DocumentRequest request, Integer id) throws IOException {
        if (validRequest(request)) {
            // chiamo il metodo già implementato nel service che torna un Document dopo averne controllato l'esistenza sul db (in caso negativo lancia un'eccezione)
            Document document = this.getDocumentById(id);
            // setto le nuove proprietà compreso di id
            // il metodo save() crea un nuovo record se nell'oggetto non è presente un id, aggiorna il record con uno specifico id se nell'oggetto è presente l'id
            // save è come un saveOrUpdate
            document.setFile(fileUtil.upload(request.getFile()));
            BeanUtils.copyProperties(request, document);
            return documentRepository.save(document);
        }
        throw new InvalidInputException("All fields are required");
    }

    private Boolean validRequest(DocumentRequest request) {

        Object[] fields = {request.getNameFile(),
                request.getTypeOfDoc(),
                request.getTypeOfFile(),
                request.getFile()};

        if(request.getFiscalCode() != null && request.getFiscalCode().length()==16) {
            for ( Object field: fields) {
                if (field == null) {
                    return false;
                }
            } return true;
        } throw new InvalidInputException("Invalid Fiscal Code");
    }
}
