package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.driverException.DriverNotExistsException;
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
        log.info("DriverService > driverRegister > Request > driver [{}]", driver);
        var driverResult = this.driverRepository.findByNameAndActive(driver.getName(), driver.getActive());
        if (driverResult != null) {
            throw new DriverNotExistsException("Driver já existente!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Driver já existente na base de dados!"));
        }
        log.info("DriverService > driverRegister > Response > Status: SUCESS > driver [{}]", driver);
        return this.driverRepository.save(driver);
        }

    public Optional<Driver> driverSearchById (String id) {
        log.info("DriverService > driverSearchById > Request > driver [{}]", id);
        return this.driverRepository.findByIdAndActive(id, true);
    }

    public Optional<Driver> driverDeleteById (String id) {
        log.info("DriverService > driverDeletedById > Request > driver [{}]", id);
        var driverResult = this.driverRepository.findByIdAndActive(id, true);
        if (driverResult.isEmpty()) {
            throw new DriverNotExistsException("Piloto não encontrado!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Id não existente na base de dados!"));
        }
        Driver driver = driverResult.get();
        driver.setActive(false);
        driver.setLastModifiedAt(LocalDate.now());
        this.driverRepository.save(driver);
        log.info("DriverService > driverDeletedById > Response > Status: SUCESS > Id [{}]", id);
        return driver;
    }
}

