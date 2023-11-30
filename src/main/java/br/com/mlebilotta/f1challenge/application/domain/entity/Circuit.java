package br.com.mlebilotta.f1challenge.application.domain.entity;

import br.com.mlebilotta.f1challenge.application.controller.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Circuit {

    @NotNull
    @Id
    private String id;

    @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
    private String name;

    @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
    private String location;

    @NotBlank(message = Constants.MESSAGE_REQUIRED_FIELD)
    private String country;

    private String url;

    @NotNull(message = Constants.MESSAGE_REQUIRED_FIELD)
    private Boolean active;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt;
}
