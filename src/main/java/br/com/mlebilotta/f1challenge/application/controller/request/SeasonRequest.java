package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record SeasonRequest(

        @NotBlank (message = Constants.MESSAGE_REQUIRED_FIELD)
        String id,
        @NotBlank (message = Constants.MESSAGE_REQUIRED_FIELD)
        @Length(min = 4, max = 4)
        LocalDate seasonYear,

        LocalDate createdAt,

        LocalDate lastModifiedAt) {
}
