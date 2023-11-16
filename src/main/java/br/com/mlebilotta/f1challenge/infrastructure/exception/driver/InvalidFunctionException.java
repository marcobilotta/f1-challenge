package br.com.mlebilotta.f1challenge.infrastructure.exception.driver;

import br.com.mlebilotta.f1challenge.infrastructure.exception.driver.CommonDriverException;
import org.springframework.http.HttpStatus;

public class InvalidFunctionException extends CommonDriverException {
    public InvalidFunctionException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}
