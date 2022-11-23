package it.aesys.courses.springboot.personregistry.service;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;

import it.aesys.courses.springboot.personregistry.repository.PersonRepository;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
    private final PersonMapperDTO personMapperDTO;
    private final PersonRepository personRepository;

    // non ho più bisogno di un dao per address lo gestisco con la PersonRepository tramite la relazione
    //private final AddressDao addressDao;

    //private final RestTemplate documentsClient;


    // non ho più le eccezioni del DAO
    // se volessi controllare le eccezioni relative ad operazioni sul db con Spring Data JPA posso controllare la DataAccessException che wrappa tutte le eccezioni ottenibili a lv. database
    // le eccezioni le devo sempre controllare o con handler globali o con try/catch o rilanciandole, ma nel caso in cui le rilancio ad un certo punto del codice devo fare il controllo altrimenti non ha senso rilanciarle

    @Autowired
    public PersonServiceImpl(PersonMapperDTO personMapperDTO, PersonRepository personRepository /*, RestTemplate documentsClient*/) {
        this.personMapperDTO = personMapperDTO;
        this.personRepository = personRepository;
        //this.documentsClient = documentsClient;
    }

    @Transactional
    public PersonDTO create(PersonDTO personDto) {
        // person ha l'address già impostato (glielo passo così dal body della request)
        // quindi per il cascade quando salvo la Person mi salva e mi relaziona anche Address
        Person person = personMapperDTO.toModel(personDto);
        person = personRepository.save(person);
        return personMapperDTO.toDto(person);
    }

    // metodo private che controlla l'input fiscalCode e controlla se la Person esiste nel db tornandola in output (in caso contrario lancia eccezione)
    private Person checkAndReturnPersonIfExistsByFiscalCode(String fiscalCode) throws ServiceException {
        if (fiscalCode != null) {
            // la findById ritorna un optional quindi faccio i controlli se è presente, in caso negativo lancio l'eccezione
            // .isEmpty = true se non è presente, .isPresent = true se presente, .get() = oggetto (dopo che ho fatto i controlli)
            Optional<Person> personOptional = personRepository.findById(fiscalCode);
            if (personOptional.isEmpty()) {
                ServiceException serviceException = new ServiceException();
                serviceException.setStatusCode(HttpStatus.NOT_FOUND.value());
                serviceException.setMessage("Person with fiscalCode: " + fiscalCode + " not found");
                throw serviceException;
            }

            return personOptional.get();
        } else {
            // se fiscalCode è nullo (non valido)
            ServiceException serviceException = new ServiceException();
            serviceException.setStatusCode(HttpStatus.BAD_REQUEST.value());
            serviceException.setMessage("Invalid input fiscalCode");
            throw serviceException;
        }
    }

    public PersonDTO get(String fiscalcode) throws ServiceException {
        // chiamo il metodo che controlla e ritorna una person se esiste e il risultto lo converto in dto
        return personMapperDTO.toDto(checkAndReturnPersonIfExistsByFiscalCode(fiscalcode));
    }

    public List<PersonDTO> getAll() {

        List<Person> allPersons = personRepository.findAll();


        List<PersonDTO> allPersonsDto = new ArrayList<>();
        allPersons.forEach( p -> allPersonsDto.add(personMapperDTO.toDto(p)));
        return allPersonsDto;

        // N.B. potrei farmi anche questo metodo per trasformare in dto direttamente nel mapper (senza ogni volta riscrivere il ciclo for nel service)
    }

    @Transactional
    public PersonDTO update(String fiscalcode, PersonDTO personDTO) throws ServiceException {
        // chiamo il metodo che controlla e ritorna una person se esiste
        Person oldPerson = this.checkAndReturnPersonIfExistsByFiscalCode(fiscalcode);
        Person updatedPerson = personMapperDTO.toModel(personDTO);

        // setto gli id in modo da poter fare l'update con il metodo save
        // save(..) --> se id != null aggiorno, se id == null salvo nuovo record (save è un saveOrUpdate)
        updatedPerson.setFiscalCode(oldPerson.getFiscalCode());
        updatedPerson.getAddress().setAddressId(oldPerson.getAddress().getAddressId());

        updatedPerson = personRepository.save(updatedPerson);
        return personMapperDTO.toDto(updatedPerson);
    }


    @Transactional
    public void delete(String fiscalcode) throws ServiceException {
        // chiamo il metodo che controlla e ritorna una person se esiste
        Person person = this.checkAndReturnPersonIfExistsByFiscalCode(fiscalcode);
        personRepository.delete(person);
    }

}




