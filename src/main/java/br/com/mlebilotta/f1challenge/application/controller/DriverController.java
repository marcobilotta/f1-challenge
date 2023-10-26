package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/piloto")
@Log4j2
public class DriverController {

    private final DriverService driverService;

    public DriverController (DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public Driver driverRegister (@Valid @RequestBody DriverRequest driverRequest) {
        log.info("DRIVER CONTROLLER > driverRegister > RESPONSE > STATUS: SUCESS");
        return this.driverService.driverRegister(driverRequest.mapearDriverRequestParaDriver(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> driverSearchById (@PathVariable String id) {
        Optional<Driver> driver = this.driverService.driverSearchById(id);
        if (driver.isEmpty()) {
            log.info("DRIVER CONTROLLER > driverSearchById > RESPONSE > STATUS: FAILED");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        log.info("DRIVER CONTROLLER > driverSearchById > RESPONSE > STATUS: SUCESS");
        return ResponseEntity.status(HttpStatus.OK).body(driver.get().mapearDriverParaDriverResponse());
    }

}
