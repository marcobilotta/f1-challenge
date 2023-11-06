package br.com.mlebilotta.f1challenge.application.controller.response;

import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;

public record DriverResponse(
        String id,
        String name,
        Double height,
        String cityOfBirth,
        String countryOfBirth,
        FunctionEnum function,
        Boolean active
) {
}
