package br.com.mlebilotta.f1challenge.infrastructure.exception.response;

import lombok.Builder;

@Builder
public record ErrorResponse(String message, String status, String cause) {

}
