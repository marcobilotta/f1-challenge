package br.com.mlebilotta.f1challenge.infrastructure.exception.driverException;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonDriverException extends RuntimeException {

    private HttpStatus statusCode;

    public CommonDriverException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
