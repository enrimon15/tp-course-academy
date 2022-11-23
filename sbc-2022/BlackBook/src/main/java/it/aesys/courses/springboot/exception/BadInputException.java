package it.aesys.courses.springboot.exception;

public class BadInputException extends Exception {

    public BadInputException() {
    }

    public BadInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInputException(String message) {
        super(message);
    }

    public BadInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
