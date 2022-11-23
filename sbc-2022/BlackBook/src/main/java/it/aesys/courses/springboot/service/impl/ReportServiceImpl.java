package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.exception.PersonHistoryNotFoundException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;
import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;
import it.aesys.courses.springboot.repository.ReportRepository;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    // inietto la repository
    private ReportRepository reportRepository;

    private ReportMapperDTO mapper;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ReportMapperDTO mapper) {
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }

    // non ho più le eccezioni del DAO
    // se volessi controllare le eccezioni relative ad operazioni sul db con Spring Data JPA posso controllare la DataAccessException che wrappa tutte le eccezioni ottenibili a lv. database
    // le eccezioni le devo sempre controllare o con handler globali o con try/catch o rilanciandole, ma nel caso in cui le rilancio ad un certo punto del codice devo fare il controllo altrimenti non ha senso rilanciarle


    @Override
    @Transactional
    public ReportDtoRequest create(ReportDtoRequest dto) throws BadInputException {
        if(dto.getFiscalCodeNumber().length() == 16 && dto.getProblemDescription().length() < 100) {
            return this.mapper.toRequestDto(this.reportRepository.save(this.mapper.toRequestModel(dto)));
        } else {
            throw new BadInputException("Bad Input.");
        }
    }

    @Override
    public List<Report> getPersonHistory(String fiscalCodeNumber) throws PersonHistoryNotFoundException {
        // findAllByFiscalCodeNumber --> metodo custom creato nella repository con il dsl
        List<Report> reports = reportRepository.findAllByFiscalCodeNumber(fiscalCodeNumber);
        if(reports.isEmpty()) {
            throw new PersonHistoryNotFoundException("No history availible, required person is clean!");
        }
        return reports;
    }


    @Override
    @Transactional
    public void delete(Integer reportTicketNumber) throws BadInputException {
        // la findById torna in output l'optional
        // .isPresent = true se esiste, .isEmpty = true se NON esiste, .get() torna l'oggetto dopo aver fatto i controlli
        Optional<Report> reportOtp = reportRepository.findById(reportTicketNumber);
        if (reportOtp.isEmpty()) {
            throw new BadInputException("Invalid Input: Ticket not found");
        }
        this.reportRepository.delete(reportOtp.get());
    }


    @Override
    @Transactional
    public ReportDtoResponse update(Integer reportTicketNumber, ReportDtoRequest updatedDto) throws BadInputException {
        Optional<Report> reportOtpional = reportRepository.findById(reportTicketNumber);
        if(reportOtpional.isEmpty()) {
            throw new BadInputException("Invalid Input: ticket not found");
        }
        // setto l'id dal vecchio report (ripreso dal db) al nuovo report che dovrà essere aggiornato
        // il metodo save() crea un nuovo record se nell'oggetto non è presente un id, aggiorna il record con uno specifico id se nell'oggetto è presente l'id
        // save è come un saveOrUpdate
        Report oldReport = reportOtpional.get();
        Report reportToUpdate = this.mapper.toRequestModel(updatedDto);
        reportToUpdate.setReportTicketNumber(oldReport.getReportTicketNumber());
        return this.mapper.toResponseDto(this.reportRepository.save(reportToUpdate));
    }
}
