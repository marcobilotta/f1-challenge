package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

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
        String function,

        LocalDate createdAt,
        LocalDate lastModifiedAt
) {
    public Driver mapearDriverRequestParaDriver(String id) {
        return Driver.builder()
                .id(validarID(id))
                .name(this.name)
                .height(this.height)
                .cityOfBirth(this.cityOfBirth)
                .countryOfBirth(this.countryOfBirth)
                .function(FunctionEnum.validateFunction(this.function))
                .active(true)
                .build();
    }

    private String validarID(String id) {
        if (Objects.isNull(id)) {
            return UUID.randomUUID().toString();
        }
        return id;
    }
}
