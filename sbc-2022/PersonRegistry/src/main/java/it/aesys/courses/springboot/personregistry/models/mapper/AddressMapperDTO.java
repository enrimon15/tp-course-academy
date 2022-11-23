package it.aesys.courses.springboot.personregistry.models.mapper;

import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperDTO {

    public AddressDTO toDto(Address address) {

        AddressDTO dto = new AddressDTO();

        dto.setStreet(address.getStreet());
        dto.setCivic(address.getCivic());
        dto.setHome(address.getHome());
        dto.setPostalCode(address.getPostalCode());

        return dto;
    }

    public Address toModel(AddressDTO dto) {

        Address a = new Address();

        a.setStreet(dto.getStreet());
        a.setCivic(dto.getCivic());
        a.setHome(dto.getHome());
        a.setPostalCode(dto.getPostalCode());

        return a;
    }


}
