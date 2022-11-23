package it.aesys.courses.springboot.models.dto;

import it.aesys.courses.springboot.models.TypeOfDoc;
import it.aesys.courses.springboot.models.TypeOfFile;
import org.springframework.web.multipart.MultipartFile;

public class DocumentRequest {
    private String nameFile;
    private TypeOfFile typeOfFile;
    private TypeOfDoc typeOfDoc;
    private String fiscalCode;
    private MultipartFile file;

    public DocumentRequest(String nameFile, TypeOfFile typeOfFile, TypeOfDoc typeOfDoc, String fiscalCode, MultipartFile file) {
        this.nameFile = nameFile;
        this.typeOfFile = typeOfFile;
        this.typeOfDoc = typeOfDoc;
        this.fiscalCode = fiscalCode;
        this.file = file;
    }
    public DocumentRequest() {
        super();
    }

    public String getNameFile() {
        return nameFile;
    }
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public TypeOfFile getTypeOfFile() {
        return typeOfFile;
    }

    public void setTypeOfFile(TypeOfFile typeOfFile) {
        this.typeOfFile = typeOfFile;
    }

    public TypeOfDoc getTypeOfDoc() {
        return typeOfDoc;
    }

    public void setTypeOfDoc(TypeOfDoc typeOfDoc) {
        this.typeOfDoc = typeOfDoc;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
