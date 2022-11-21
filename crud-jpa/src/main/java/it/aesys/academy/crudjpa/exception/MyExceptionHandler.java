package it.aesys.academy.crudjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MyCustomException.class)
    public ResponseEntity<ApiError> libraryExceptionHandling(MyCustomException ex) {
        ApiError error = new ApiError();
        error.setStatusCode(ex.getStatusCode());
        error.setMessage(ex.getMessage());

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(ex.getStatusCode()).body(error);
        return errorResponse;
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<ApiError> handleGenericException(Exception ex) {
        System.out.println(ex);
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ApiError error = new ApiError();
        error.setStatusCode(statusCode);
        error.setMessage("GENERIC ERROR");

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(statusCode).body(error);
        return errorResponse;
    }


}
