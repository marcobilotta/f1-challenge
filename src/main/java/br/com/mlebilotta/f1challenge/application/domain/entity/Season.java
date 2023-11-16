package br.com.mlebilotta.f1challenge.application.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Season {

    @Id
    private String id;

    @Column(name = "season_year")
    private LocalDate seasonYear;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lasModifiedAt;
}
