package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.DriverAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver driverRegister(Driver driver) {
        try {
            log.info("DRIVER SERVICE > driverRegister > driver [{}]", driver);
            validateTheExistenceOfTheDriver(driver);
            this.driverRepository.save(driver);
            return driver;
        } catch (Exception ex){
            log.error("PACIENTE SERVICE > driverRegister > Driver [{}] já cadastrado! > CAUSA: [{}]", driver.getName(), ex.getCause());
            throw new DriverAlreadyExistsException(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, ex.getCause());
        }
    }
    private Boolean validateTheExistenceOfTheDriver (Driver driver) {
        var driverResult = this.driverRepository.findByNameAndActive(driver.getName(), driver.getActive());
        if (driverResult == null) {
            return true;
        }
        throw new IllegalArgumentException("Piloto já Cadastrado!", new Throwable("Piloto Existente na Base de Dados"));
    }
}

