package it.aesys.courses.springboot.personregistry.service;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.DocumentDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;

import it.aesys.courses.springboot.personregistry.repository.PersonRepository;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    private final RestTemplate restTemplate;


    // non ho più le eccezioni del DAO
    // se volessi controllare le eccezioni relative ad operazioni sul db con Spring Data JPA posso controllare la DataAccessException che wrappa tutte le eccezioni ottenibili a lv. database
    // le eccezioni le devo sempre controllare o con handler globali o con try/catch o rilanciandole, ma nel caso in cui le rilancio ad un certo punto del codice devo fare il controllo altrimenti non ha senso rilanciarle

    @Autowired
    public PersonServiceImpl(PersonMapperDTO personMapperDTO, PersonRepository personRepository, RestTemplate restTemplate) {
        this.personMapperDTO = personMapperDTO;
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public PersonDTO create(PersonDTO personDto) {
        // person ha l'address già impostato (glielo passo così dal body della request)
        // quindi per il cascade quando salvo la Person mi salva e mi relaziona anche Address
        Person person = personMapperDTO.toModel(personDto);
        person = personRepository.save(person);

        PersonDTO personDtoRes = personMapperDTO.toDto(person);
        personDtoRes.setDocuments(this.getDocumentsByCf(personDtoRes.getFiscalCode()));
        return personDtoRes;
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
        // poi ritorno il personDto dopo aver settato i documenti relativi (con la chiamata al microservizio adibito)
        PersonDTO personDto = personMapperDTO.toDto(checkAndReturnPersonIfExistsByFiscalCode(fiscalcode));
        personDto.setDocuments(this.getDocumentsByCf(personDto.getFiscalCode()));
        return personDto;
    }

    public List<PersonDTO> getAll() {

        List<Person> allPersons = personRepository.findAll();


        List<PersonDTO> allPersonsDto = new ArrayList<>();
        allPersons.forEach( p -> {
            PersonDTO personDto = personMapperDTO.toDto(p);
            personDto.setDocuments(getDocumentsByCf(personDto.getFiscalCode()));
            allPersonsDto.add(personDto);
        });
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

        // creo e ritorno il personDto dopo aver settato i documenti relativi (con la chiamata al microservizio adibito)
        PersonDTO personDto = personMapperDTO.toDto(updatedPerson);
        personDto.setDocuments(this.getDocumentsByCf(personDto.getFiscalCode()));
        return personDto;
    }


    @Transactional
    public void delete(String fiscalcode) throws ServiceException {
        // chiamo il metodo che controlla e ritorna una person se esiste
        Person person = this.checkAndReturnPersonIfExistsByFiscalCode(fiscalcode);
        personRepository.delete(person);
    }

    // metodo che permette di contattare il servizio relativo ai documenti per ottenere la lista di documenti dato in input un cf
    // c'è bisogno di startare anche il servizio relativo ai documents
    private List<DocumentDTO> getDocumentsByCf(String cf) {
        // url per ottenere la lista di documenti dato un cf
        String url = "http://localhost:8081/document?cf=" + cf;
        // uno dei modi per chiamare un servizio esterno tramite rest template
        // specifico url, metodo http, eventuale oggetto da passare nel body (nel caso di post/put/patch), tipo dell'output che ci aspettiamo
        ResponseEntity<List<DocumentDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<DocumentDTO>>(){} );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            // se ok
            return response.getBody();
        } else {
            // se non ok stampo l'errore e setto i documenti come null per non bloccare l'applicazione in caso di guasti sull'altro microservizio
            System.out.println("Unable to get documents by cf: " + cf + ", statusCode: " + response.getStatusCode().value());
            return null;
        }
    }

}




