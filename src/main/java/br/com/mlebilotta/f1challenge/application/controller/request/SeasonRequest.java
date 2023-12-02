package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.infrastructure.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SeasonRequest(
        @NotNull(message = Constants.MESSAGE_REQUIRED_FIELD)
        @Pattern(regexp = "^\\d{4}$", message = "O campo deve conter 4 dígitos numéricos!")
        String seasonYear) {

}
