package br.com.mlebilotta.f1challenge.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class DriverNotExistsException extends CommonDriverException {
    public DriverNotExistsException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}
