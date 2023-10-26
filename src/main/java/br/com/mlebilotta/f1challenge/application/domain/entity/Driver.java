package br.com.mlebilotta.f1challenge.application.domain.entity;

import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Enumerated(EnumType.STRING)
    private FunctionEnum function;
    private Boolean active;

    @CreationTimestamp
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

    public Boolean getActive() {
        return this.active;
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

    public void setFunction(FunctionEnum function) {
        this.function = function;
    }

    public void setActive (Boolean active) {
        this.active = active;
    }
}
