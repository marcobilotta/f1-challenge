package br.com.mlebilotta.f1challenge.infrastructure.exception;

import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CommonDriverException.class)
    public ResponseEntity<ErrorResponse> CommonDriverException(CommonDriverException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(ex.getStatusCode().toString())
                .message(ex.getMessage())
                .cause(ex.getCause().getMessage())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}
