package br.com.mlebilotta.f1challenge.application.domain.entity;

import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
}
