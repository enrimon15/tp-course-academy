package it.aesys.courses.springboot.personregistry.controller;

import it.aesys.courses.springboot.personregistry.models.mapper.ApiErrorDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.ErrorDTO;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorManageController {


    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ApiErrorDTO> errorManage(ServiceException ex, WebRequest request) {


        return getErrorMessages(ex, request);
    }


    public ResponseEntity<ApiErrorDTO> getErrorMessages (ServiceException bre, WebRequest request) {


        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(bre.getStatusCode());
        error.setMessage(bre.getMessage());
        error.setPath(request.getContextPath());

        ResponseEntity<ApiErrorDTO> errorResponse = ResponseEntity.status(HttpStatus.resolve(bre.getStatusCode())).body(error);
        return errorResponse;

    }

    // handling generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGenericException(Exception e, WebRequest request) {
        System.out.println("Errore: " + e);
        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(500);
        error.setMessage("Generic Error");
        error.setPath(request.getContextPath());
        return ResponseEntity.internalServerError().body(error);
    }

}
