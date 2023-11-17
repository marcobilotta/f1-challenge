package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record SeasonRequest(
        @NotNull(message = Constants.MESSAGE_REQUIRED_FIELD)
        @Length(min = 4, max = 4)
        String seasonYear) {

}
