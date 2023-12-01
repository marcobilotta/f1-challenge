package br.com.mlebilotta.f1challenge.infrastructure.exception.circuit;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonCircuitException extends RuntimeException {
    private HttpStatus statusCode;
    public CommonCircuitException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
