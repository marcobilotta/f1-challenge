package br.com.mlebilotta.f1challenge.application.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
public record DriverResponse(
        String id,
        String name,
        Double height,
        String cityOfBirth,
        String countryOfBirth,
        String function,
        Boolean active
) {
}
