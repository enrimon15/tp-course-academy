package it.aesys.courses.springboot.personregistry.models.mapper;

import java.time.LocalDate;

public class DocumentDTO {
    private Integer idDoc;
    private String nameFile;
    private LocalDate dataOfInput;

    // metto le String e non gli enum in quanto utilizzero questo dto solo per get e gli enum che ho nel microservizio document in json vengono trasformati in stringhe, quindi posso prenderli come stringhe
    private String typeOfFile;
    private String typeOfDoc;
    private String file;
    private String fiscalCode;


    public Integer getIdDoc() {
        return idDoc;
    }
    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }
    public String getNameFile() {
        return nameFile;
    }
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    public LocalDate getDataOfInput() {
        return dataOfInput;
    }
    public void setDataOfInput(LocalDate dataOfInput) {
        this.dataOfInput = dataOfInput;
    }
    public String getTypeOfFile() {
        return typeOfFile;
    }
    public void setTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }
    public String getTypeOfDoc() {
        return typeOfDoc;
    }
    public void setTypeOfDoc(String typeOfDoc) {
        this.typeOfDoc = typeOfDoc;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public String getFiscalCode() {
        return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
