package it.aesys.courses.springboot.exception.handler;

import it.aesys.courses.springboot.exception.AlreadyExistsException;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.exception.NotFoundException;
import it.aesys.courses.springboot.models.dto.ErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({AlreadyExistsException.class, InvalidInputException.class, TypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e){
        ErrorResponse response = new ErrorResponse();
        response.setError("Bad Request");
        response.setStatus(400);
        response.setMessage(e.getMessage());
        response.setTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(Exception e){
        ErrorResponse response = new ErrorResponse();
        response.setError("Not Found");
        response.setStatus(404);
        response.setMessage(e.getMessage());
        response.setTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // handling generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        System.out.println("Errore: " + e);
        ErrorResponse response = new ErrorResponse();
        response.setError("Generic Error");
        response.setStatus(500);
        response.setMessage("Generic Error");
        response.setTime(LocalDateTime.now());
        return ResponseEntity.internalServerError().body(response);
    }

}
