package it.aesys.courses.springboot.personregistry.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    public Integer addressId;

    @Column(name = "street")
    public String street;
    @Column(name = "civic")
    public String civic;
    @Column(name = "postal_code")
    public Integer postalCode;

    // se mappo un enum dal db al codice java devo necessariamente inserire il column definition
    // se invece ragiono direttamente ad oggetti (mi faccio creare le tabelle da hibernate/jpa) non ne ho biogno --> metto soltanto @Enumerated(EnumType.STRING)
    @Column(name = "home", columnDefinition = "enum('RESIDENCE','DOMICILE')")
    @Enumerated(EnumType.STRING)
    public EnumAddress home;

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCivic() {
        return civic;
    }

    public void setCivic(String civic) {
        this.civic = civic;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public EnumAddress getHome() {
        return home;
    }

    public void setHome(EnumAddress home) {
        this.home = home;
    }

    public Integer getAddressId() {
        return addressId;
    }
}
