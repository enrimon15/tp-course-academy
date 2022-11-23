package it.aesys.courses.springboot.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc")
    private Integer idDoc;

    @Column(name = "name_file")
    private String nameFile;

    @Column(name = "data_of_input")
    private LocalDate dataOfInput;

    // se mappo un enum dal db al codice java devo necessariamente inserire il column definition
    // se invece ragiono direttamente ad oggetti (mi faccio creare le tabelle da hibernate/jpa) non ne ho biogno --> metto soltanto @Enumerated(EnumType.STRING)
    @Column(name = "type_of_file", columnDefinition = "enum('PNG','JPEG','PDF')")
    @Enumerated(EnumType.STRING)
    private TypeOfFile typeOfFile;

    // se mappo un enum dal db al codice java devo necessariamente inserire il column definition
    // se invece ragiono direttamente ad oggetti (mi faccio creare le tabelle da hibernate/jpa) non ne ho biogno --> metto soltanto @Enumerated(EnumType.STRING)
    @Column(name = "type_of_doc", columnDefinition = "enum('ID_CARD','DRIVER_LICENSE')")
    @Enumerated(EnumType.STRING)
    private TypeOfDoc typeOfDoc;

    // se mappo un TEXT dal db al codice java devo necessariamente inserire il column definition, perchè non è un normale varchar ma è un text (da come è stata creata la tabella)
    // se invece ragiono direttamente ad oggetti (mi faccio creare le tabelle da hibernate/jpa) non ne ho bisogno
    // in realtà come tipo db si dovrebbe usare un BLOB --> binary large object e si mappa nella entity in questo modo:
    /*
    @Lob(type = LobType.BLOB)
    private byte[] file;
     */
    @Column(name = "file", columnDefinition = "TEXT")
    private String file;

    @Column(name = "fiscal_code")
    private String fiscalCode;

    public Document() {
        super();
    }
    public Document(Integer idDoc, String nameFile, LocalDate dataOfInput, TypeOfFile typeOfFile, TypeOfDoc typeOfDoc, String file, String fiscalCode) {
        this.idDoc = idDoc;
        this.nameFile = nameFile;
        this.dataOfInput = dataOfInput;
        this.typeOfFile = typeOfFile;
        this.typeOfDoc = typeOfDoc;
        this.file = file;
        this.fiscalCode = fiscalCode;
    }
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
