package it.aesys.courses.springboot.models;

public enum TypeOfFile {
    PDF(Values.PDF),
    JPEG(Values.JPEG),
    PNG(Values.PNG);

    private String value;

    TypeOfFile(String value) {}

    public static class Values {
        public static final String PDF = "PDF";
        public static final String JPEG = "JPEG";
        public static final String PNG = "PNG";
    }
}
