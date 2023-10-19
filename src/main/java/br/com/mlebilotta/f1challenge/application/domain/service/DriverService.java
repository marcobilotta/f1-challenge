package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver driverRegister(Driver driver) {
        this.driverRepository.save(driver);
        return driver;
    }
}
