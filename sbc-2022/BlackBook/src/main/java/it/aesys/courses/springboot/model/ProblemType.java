package it.aesys.courses.springboot.model;

public enum ProblemType {

    NONPAYMENT("NONPAYMENT"),
    PROPERTY_DAMAGED("PROPERTY_DAMAGED"),
    FAILURE_TO_RETURN("FAILURE_TO_RETURN"),
    OTHER("OTHER");

    private String label;

    ProblemType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public ProblemType getFromLabel(String label) {  //possible debug needed
        for (ProblemType p : ProblemType.values()) {
            if (p.label.equals(label)) {
                return p;
            }
        }
        return null;
    }
}
