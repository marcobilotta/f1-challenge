package br.com.mlebilotta.f1challenge.infrastructure.exception.circuit;

import org.springframework.http.HttpStatus;

public class CircuitAlreadyExistsException extends CommonCircuitException {
    public CircuitAlreadyExistsException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}

