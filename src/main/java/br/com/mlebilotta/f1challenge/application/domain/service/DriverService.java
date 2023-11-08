package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.DriverAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Log4j2
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver driverRegister(Driver driver) {
        var driverResult = this.driverRepository.findByNameAndActive(driver.getName(), driver.getActive());
        if (driverResult != null) {
            throw new RuntimeException("Usuário já existente!");
        }
        log.info("DRIVER SERVICE > driverRegister > driver [{}]", driver);
        return this.driverRepository.save(driver);
        }

    public Optional<Driver> driverSearchById (String id) {
        log.info("DRIVER SERVICE > driverSearchById > driver [{}]", id);
        return this.driverRepository.findByIdAndActive(id, true);
    }

    public Driver driverDeleteById (String id) {
        var driverResult = this.driverRepository.findByIdAndActive(id, true);
        if (driverResult.isEmpty()) {
            throw new RuntimeException("Piloto não encontrado!");
        }
        Driver driver = driverResult.get();
        driver.setActive(false);
        driver.setLastModifiedAt(LocalDate.now());
        this.driverRepository.save(driver);
        log.info("DriverService > driverDeletedById > Response > driver [{}]", id);
        return driver;
    }
    private Boolean validateTheExistenceOfTheDriver (Driver driver) {
        var driverResult = this.driverRepository.findByNameAndActive(driver.getName(), driver.getActive());
        if (driverResult == null) {
            return true;
        }
        throw new IllegalArgumentException("Piloto já Cadastrado!", new Throwable("Piloto Existente na Base de Dados"));
    }
}

