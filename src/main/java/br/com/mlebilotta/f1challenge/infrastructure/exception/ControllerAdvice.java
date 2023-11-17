package br.com.mlebilotta.f1challenge.infrastructure.exception;

import br.com.mlebilotta.f1challenge.infrastructure.exception.driver.CommonDriverException;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorFieldsResponse;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorResponse;
import br.com.mlebilotta.f1challenge.infrastructure.exception.season.CommonSeasonException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.awt.event.FocusEvent;
import java.time.format.DateTimeParseException;
import java.util.List;

@Log4j2
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorFieldsResponse>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        log.error("DriverController > driverRegister > Response > Driver não possui todos os campos obrigatórios - CAUSA: [{}]", errors.stream().map(ErrorFieldsResponse::new).toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.stream().map(ErrorFieldsResponse::new).toList());
    }
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> dateTimeParseException(DateTimeParseException ex) {
        var errors = ex.getMessage();
        log.error("SeasonController > seasonRegister > Response > Erro na validação do campo SeasonYear - CAUSA: [{}]", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(CommonDriverException.class)
    public ResponseEntity<ErrorResponse> commonDriverException(CommonDriverException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(ex.getStatusCode().toString())
                .message(ex.getMessage())
                .cause(ex.getCause().getMessage())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }

    @ExceptionHandler(CommonSeasonException.class)
    public ResponseEntity<ErrorResponse> commonSeasonException(CommonSeasonException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(ex.getStatusCode().toString())
                .message(ex.getMessage())
                .cause(ex.getCause().getMessage())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}
