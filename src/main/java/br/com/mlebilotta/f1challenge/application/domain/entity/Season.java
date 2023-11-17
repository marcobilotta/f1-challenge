package br.com.mlebilotta.f1challenge.application.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

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

    public Year formatDateSeason(String year) {
        DateTimeFormatter standardYearFormat = DateTimeFormatter.ofPattern("YYYY");
        Year formattedYear = Year.parse(year, standardYearFormat);
        return formattedYear;
    }

}
