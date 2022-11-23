package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;

public class ReportRequest {
    private ReportDtoRequest  reportDtoRequest= new ReportDtoRequest();

    public ReportRequest() {
        super();
    }

    public ReportDtoRequest getReportDtoRequest() {
        return reportDtoRequest;
    }

    public void setReportDtoRequest(ReportDtoRequest reportDtoRequest) {
        this.reportDtoRequest = reportDtoRequest;
    }
}
