package br.com.mlebilotta.f1challenge.application.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Table(name = "DRIVER")
@Entity

public class Driver {

    @Id
    private String id;
    private String name;
    private Double height;
    private String cityOfBirth;
    private String countryOfBirth;
    private String function;
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getFunction() {
        return function;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
