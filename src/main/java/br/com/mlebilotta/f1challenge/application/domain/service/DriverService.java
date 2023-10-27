package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.repository.DriverRepository;
import lombok.extern.log4j.Log4j2;
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

    public Optional<Driver> driverDeleteById (String id) {
        var driverResult = this.driverRepository.findByIdAndActive(id, true);
        if (driverResult.isEmpty()) {
            throw new RuntimeException("Piloto não encontrado!");
        }
        driverResult.get().setActive(false);
        driverResult.get().setLastModifiedAt(LocalDate.now());
        Driver driver = driverResult.get();
        this.driverRepository.save(driver);
        log.info("DRIVER SERVICE > driverDeletedById > driver [{}]", id);
        return driverResult;
    }
}


