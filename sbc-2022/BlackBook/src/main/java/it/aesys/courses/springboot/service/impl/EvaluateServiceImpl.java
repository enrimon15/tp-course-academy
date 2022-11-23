package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;
import it.aesys.courses.springboot.repository.ReportRepository;
import it.aesys.courses.springboot.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    private ReportRepository reportRepository;

    @Autowired
    public EvaluateServiceImpl(ReportRepository reportRepository, ReportMapperDTO mapper) {
        this.reportRepository = reportRepository;
    }

    @Override
    public boolean evaluate(String fiscalCodeNumber) {
        // potrei fare una count query con il dsl
        if (reportRepository.findAllByFiscalCodeNumber(fiscalCodeNumber).size() < 3) {
            return true;
        } else {
            return false;
        }
    }
}
