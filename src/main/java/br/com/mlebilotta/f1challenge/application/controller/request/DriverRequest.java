package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;

import java.util.Objects;
import java.util.UUID;

public record DriverRequest(
        String name,
        Double height,
        String cityOfBirth,
        String countryOfBirth,
        String function
) {

    public Driver mapearDriverRequestParaDriver(String id) {
        Driver driver = new Driver();

        driver.setId(validarID(id));
        driver.setName(this.name);
        driver.setHeight(this.height);
        driver.setCityOfBirth(this.cityOfBirth);
        driver.setCountryOfBirth(this.countryOfBirth);
        driver.setFunction(this.function);

        return driver;
    }

    private String validarID(String id) {
        if (Objects.isNull(id)) {
            return UUID.randomUUID().toString();
        }
        return id;
    }
}
