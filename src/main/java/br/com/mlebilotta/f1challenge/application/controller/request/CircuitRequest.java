package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.infrastructure.Constants;
import jakarta.validation.constraints.NotBlank;

public record CircuitRequest(

        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        String name,
        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        String location,
        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        String country,
        String url
) {
}
