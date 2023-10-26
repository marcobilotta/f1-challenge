package br.com.mlebilotta.f1challenge.application.controller.response;

public record DriverResponse(
        String id,
        String name,
        Double height,
        String cityOfBirth,
        String countryOfBirth,
        String function
) {
}
