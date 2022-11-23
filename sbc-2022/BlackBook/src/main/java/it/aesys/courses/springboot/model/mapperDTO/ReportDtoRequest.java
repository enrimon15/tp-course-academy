package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.ProblemType;

public class ReportDtoRequest {

    private String fiscalCodeNumber;
    private ProblemType problemType;
    private String problemDescription;

    public ReportDtoRequest() {
    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
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
