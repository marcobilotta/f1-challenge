package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record DriverRequest(

        String id,
        @NotBlank (message = Constants.MESSAGE_REQUIRED_FIELD)
        @Length(min = 3, max = 50)
        String name,

        Double height,

        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        String cityOfBirth,

        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        @Length(min = 4)
        String countryOfBirth,

        @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
        @Length(min = 6)
        String driverFunction,

        LocalDate createdAt,
        LocalDate lastModifiedAt
) {

}
