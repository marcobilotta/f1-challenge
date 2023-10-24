package br.com.mlebilotta.f1challenge.application.controller.request;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Objects;
import java.util.UUID;

public record DriverRequest(

        @NotBlank (message = "* Campo Obrigatório! *")
        @Length(min = 3, max = 50)
        String name,

         Double height,

        @NotBlank(message = "* Campo Obrigatório! *")
        @Length(min = 6)
        String cityOfBirth,

        @NotBlank(message = "* Campo Obrigatório! *")
        @Length(min = 4)
        String countryOfBirth,

        @NotBlank(message = "* Campo Obrigatório! *")
        @Length(min = 6)
        String function


) {

    public Driver mapearDriverRequestParaDriver(String id) {
        Driver driver = new Driver();
        driver.setId(validarID(id));
        driver.setName(name);
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
