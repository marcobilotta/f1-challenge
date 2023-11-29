package br.com.mlebilotta.f1challenge.infrastructure.exception.season;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonSeasonException extends RuntimeException {
    private HttpStatus statusCode;

    public CommonSeasonException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
