package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportMapperDTO {

    public ReportDtoResponse toResponseDto(Report report) {

        ReportDtoResponse responseDto = new ReportDtoResponse();
        responseDto.setProblemType(report.getProblemType());
        responseDto.setProblemDescription(report.getProblemDescription());
        responseDto.setReportTicketNumber(report.getReportTicketNumber());
        responseDto.setReportTicketNumber(report.getReportTicketNumber());
        responseDto.setFiscalCodeNumber(report.getFiscalCodeNumber());

        return responseDto;
    }

    public Report toResponseModel(ReportDtoResponse responseDto) {

        Report report = new Report();
        report.setProblemType(responseDto.getProblemType());
        report.setProblemDescription(responseDto.getProblemDescription());
        report.setReportTicketNumber(responseDto.getReportTicketNumber());
        report.setReportTicketNumber(responseDto.getReportTicketNumber());

        return report;
    }

    public ReportDtoRequest toRequestDto(Report report) {

        ReportDtoRequest requestDto = new ReportDtoRequest();
        requestDto.setProblemType(report.getProblemType());
        requestDto.setProblemDescription(report.getProblemDescription());
        requestDto.setFiscalCodeNumber(report.getFiscalCodeNumber());
        return requestDto;
    }

    public Report toRequestModel(ReportDtoRequest requestDto) {

        Report report = new Report();
        report.setProblemType(requestDto.getProblemType());
        report.setProblemDescription(requestDto.getProblemDescription());
        report.setFiscalCodeNumber(requestDto.getFiscalCodeNumber());
        return report;
    }

}
