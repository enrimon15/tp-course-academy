package it.aesys.courses.springboot.personregistry.models;

public enum EnumGender {
    M(Values.M),
    F(Values.F);

    private String value;

    EnumGender(String value) {}

    public static class Values {
        public static final String M = "M";
        public static final String F = "F";
    }
}
