package it.aesys.courses.springboot.personregistry.models;

public enum EnumAddress {
    RESIDENCE(Values.RESIDENCE),
    DOMICILE(Values.DOMICILE);

    private String value;

    EnumAddress(String value) {}

    public static class Values {
        public static final String RESIDENCE = "RESIDENCE";
        public static final String DOMICILE = "DOMICILE";
    }
}
