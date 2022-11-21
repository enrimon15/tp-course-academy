package it.aesys.academy.crudjpa.exception;

public class ApiError {

    private Integer statusCode;
    private String message;

    public ApiError() {}

    public ApiError(Integer statusCode, String message, String path) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
