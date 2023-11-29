package br.com.mlebilotta.f1challenge.infrastructure.exception.season;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class SeasonAlreadyExistsException extends CommonSeasonException {
    public SeasonAlreadyExistsException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}
