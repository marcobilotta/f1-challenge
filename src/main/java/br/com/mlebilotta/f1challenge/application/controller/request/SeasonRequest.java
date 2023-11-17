package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.validation.constraints.NotNull;

public record SeasonRequest(
        @NotNull(message = Constants.MESSAGE_REQUIRED_FIELD)
        String seasonYear) {

}
