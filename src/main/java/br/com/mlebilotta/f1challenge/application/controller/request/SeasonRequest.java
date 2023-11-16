package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Year;

public record SeasonRequest(

        String id,
        @NotNull(message = Constants.MESSAGE_REQUIRED_FIELD)
        @FutureOrPresent
        Year seasonYear,
        LocalDate createdAt,
        LocalDate lastModifiedAt) {

}
