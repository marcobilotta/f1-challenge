package br.com.mlebilotta.f1challenge.infrastructure.exception.response;

import org.springframework.validation.FieldError;

public record ErrorFieldsResponse(String field, String message) {

    public ErrorFieldsResponse(FieldError error) {
        this (error.getField(), error.getDefaultMessage());
    }
}
