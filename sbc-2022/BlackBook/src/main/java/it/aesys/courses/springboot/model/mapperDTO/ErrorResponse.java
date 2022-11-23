package it.aesys.courses.springboot.model.mapperDTO;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String error;
    private Integer status;
    private String message;
    private LocalDateTime time;

    public ErrorResponse() {
    }

    public ErrorResponse(String error, Integer status, String message, LocalDateTime time) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
