package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;

public class ReportResponse {
    private ReportDtoResponse reportDtoResponse= new ReportDtoResponse();

    public ReportResponse() {
        super();
    }

    public ReportDtoResponse getReportDtoResponse() {
        return reportDtoResponse;
    }

    public void setReportDtoResponse(ReportDtoResponse reportDtoResponse) {
        this.reportDtoResponse = reportDtoResponse;
    }

}
