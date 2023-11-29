package br.com.mlebilotta.f1challenge.infrastructure.exception.driver;

import br.com.mlebilotta.f1challenge.infrastructure.exception.driver.CommonDriverException;
import org.springframework.http.HttpStatus;

public class DriverAlreadyExistsException extends CommonDriverException {
    public DriverAlreadyExistsException (String message, HttpStatus statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}
