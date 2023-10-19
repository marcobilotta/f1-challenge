package br.com.mlebilotta.f1challenge.application.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "DRIVER")
@Entity
public class Driver {

    @Id
    private String id;
    private String name;
    private String cityOfBirth;
    private String countryOfBirth;
    private String function;
}
