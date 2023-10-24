package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver driverRegister(Driver driver) {
        var nameDriver = this.driverRepository.findByname(driver.getName());
        if (nameDriver != null) {
            System.out.println("Usuário já existente!");
            return driver;
        } else {
            this.driverRepository.save(driver);
            return driver;
        }
    }
}
