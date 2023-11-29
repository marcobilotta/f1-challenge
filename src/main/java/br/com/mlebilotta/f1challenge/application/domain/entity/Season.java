package br.com.mlebilotta.f1challenge.application.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;

@Entity
@Getter
@Setter
public class Season {

    @Id
    private String id;

    @Column(name = "season_year")
    private Year seasonYear;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt;

}


