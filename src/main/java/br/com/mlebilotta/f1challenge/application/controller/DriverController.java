package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.DriverMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import br.com.mlebilotta.f1challenge.infrastructure.exception.driverException.DriverNotExistsException;
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
    private final DriverMapper driverMapper;

    public DriverController (DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @PostMapping
    public ResponseEntity<DriverResponse> driverRegister (@Valid @RequestBody DriverRequest driverRequest) {
        log.info("DRIVER CONTROLLER > driverRegister > RESPONSE > STATUS: SUCESS");
        this.driverService.driverRegister(driverMapper.driverRequestToDriver(driverRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> driverSearchById (@PathVariable String id) {
        Optional<Driver> driver = this.driverService.driverSearchById(id);
        log.info("DriverController > driverSearchById > Response > Status: SUCESS");
        if (driver.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(driverMapper.driverToDriverResponse(driver.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DriverResponse> driverDeleteById (@PathVariable String id) {
        log.info("DriverController > driverDeleteById > Request > Driver [{}]", id);
        Optional<Driver> driver = this.driverService.driverDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(driverMapper.driverToDriverResponse(driver.get()));
        }

    @PutMapping("/{id}")
    public ResponseEntity<DriverResponse> driverUpdateById(@Valid @PathVariable String id, @RequestBody DriverRequest driverRequest) {
        log.info("DriverController > driverUpdateById > Request > Driver id [{}]", id);
        var driver = driverMapper.driverRequestToDriver(driverRequest);
        this.driverService.driverUpdateById(id, driver);
        log.info("DriverController > driverUpdateById > Response > Status: SUCESS > Driver [{}]", driver);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
