package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
        this.driverRepository.save(driver);
        return driver;
        }
}


