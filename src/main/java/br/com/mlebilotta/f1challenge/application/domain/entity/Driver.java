package br.com.mlebilotta.f1challenge.application.domain.entity;

import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


//@Table(name = "DRIVER")
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Getter
@Setter
@Builder
@ToString
public class Driver {

    @Id
    private String id;
    private String name;
    private Double height;
    private String cityOfBirth;
    private String countryOfBirth;

    @Enumerated(EnumType.STRING)
    private FunctionEnum function;

    private Boolean active;

    private LocalDate createdAt;
    private LocalDate lastModifiedAt;

    public DriverResponse mapearDriverParaDriverResponse() {
        return DriverResponse.builder()
                .id(id)
                .name(name)
                .height(height)
                .cityOfBirth(cityOfBirth)
                .countryOfBirth(countryOfBirth)
                .function(function.toString())
                .build();
    }
}
