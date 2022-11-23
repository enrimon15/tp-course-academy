package it.aesys.courses.springboot.exception;

public class PersonHistoryNotFoundException extends Exception {

    public PersonHistoryNotFoundException() {
    }

    public PersonHistoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonHistoryNotFoundException(String message) {
        super(message);
    }

    public PersonHistoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
