package br.com.mlebilotta.f1challenge.application.controller.response;

import java.time.LocalDate;
import java.time.Year;

public record SeasonResponse(
        String id,
        Year seasonYear,
        LocalDate createdAt,
        LocalDate lastModifiedAt) {

}
