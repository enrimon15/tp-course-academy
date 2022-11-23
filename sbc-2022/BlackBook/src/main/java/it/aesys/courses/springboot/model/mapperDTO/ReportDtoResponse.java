package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.ProblemType;

public class ReportDtoResponse {

    private String fiscalCodeNumber;
    private Integer reportTicketNumber;
    private ProblemType problemType;
    private String problemDescription;

    public ReportDtoResponse() {
    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }

    public Integer getReportTicketNumber() {
        return reportTicketNumber;
    }

    public void setReportTicketNumber(Integer reportTicketNumber) {
        this.reportTicketNumber = reportTicketNumber;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }
}
