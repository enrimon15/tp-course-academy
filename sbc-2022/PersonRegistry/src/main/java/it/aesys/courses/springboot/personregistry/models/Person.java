package it.aesys.courses.springboot.personregistry.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "person")
public class Person {

    // non è autoincrement perchè l'id è il CF
    @Id
    @Column(name = "fiscal_code")
    private String fiscalCode;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    // se mappo un enum dal db al codice java devo necessariamente inserire il column definition
    // se invece ragiono direttamente ad oggetti (mi faccio creare le tabelle da hibernate/jpa) non ne ho biogno --> metto soltanto @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "enum('M','F')")
    @Enumerated(EnumType.STRING)
    private EnumGender gender;

    // relazione uno a uno, gli assegno i cascade, la colonna di join è "address_id" nella tabella "person"
    // non ci serve la relazione anche dalla parte opposta (Address) quindi mappiamo unidirezionale
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "cell_number")
    private String cellNumber;


    public Person() {
        super();
    }

    public Person(String n, String s, String fC, EnumGender g, Address a, LocalDate bD, String cN) {
        this.name = n;
        this.surname = s;
        this.fiscalCode = fC;
        this.gender = g;
        this.address = a;
        this.birthDate = bD;
        this.cellNumber = cN;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
}
