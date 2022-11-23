package it.aesys.courses.springboot.personregistry.models;

public class AddressDTO {

    public String street;
    public String civic;
    public Integer postalCode;
    public EnumAddress home;

    public AddressDTO() {
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
}
