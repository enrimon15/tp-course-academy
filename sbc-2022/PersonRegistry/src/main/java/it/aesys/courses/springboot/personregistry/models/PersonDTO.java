package it.aesys.courses.springboot.personregistry.models;

import it.aesys.courses.springboot.personregistry.models.mapper.DocumentDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.Documents;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PersonDTO {
//commento prova
    private String name;
    private String surname;
    private String fiscalCode;
    private EnumGender gender;
    private AddressDTO address;
    private LocalDate birthDate;

    private String cellNumber;

    private Documents documents;

    public PersonDTO() {
        super();
    }

    public PersonDTO(String n, String s, String fC, EnumGender g, AddressDTO a, LocalDate bD, String cN) {
        this.name = n;
        this.surname = s;
        this.fiscalCode = fC;
        this.gender = g;
        this.address = a;
        this.birthDate = bD;
        this.cellNumber = cN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fiscalCode=" + fiscalCode +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }
}
