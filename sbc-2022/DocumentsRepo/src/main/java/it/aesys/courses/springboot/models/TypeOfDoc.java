package it.aesys.courses.springboot.models;

public enum TypeOfDoc {
    ID_CARD(Values.ID_CARD),
    DRIVER_LICENSE(Values.DRIVER_LICENSE);

    private String value;

    TypeOfDoc(String value) {}

    public static class Values {
        public static final String ID_CARD = "ID_CARD";
        public static final String DRIVER_LICENSE = "DRIVER_LICENSE";
    }

}
