package it.aesys.courses.springboot.personregistry.models.mapper;

import java.util.ArrayList;
import java.util.List;

public class ApiErrorDTO {

    private Integer statusCode;
    private String message;
    private String path;
    private List<ErrorDTO> errors;

    public ApiErrorDTO() {
        errors = new ArrayList<>();
    }

    public ApiErrorDTO(Integer statusCode, String message, String path, List<ErrorDTO> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.errors = errors;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
