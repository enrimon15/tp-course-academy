package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;

import java.util.Collection;
import java.util.List;

public interface PersonService {
    public PersonDTO create(PersonDTO personDto);
    public PersonDTO get(String fiscalcode) throws ServiceException;
    public List<PersonDTO> getAll();
    public PersonDTO update(String fiscalcode, PersonDTO personDTO) throws ServiceException;
    public void delete (String fiscalcode) throws ServiceException;

}
