package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.DriverMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/piloto")
@Log4j2
public class DriverController {

    private final DriverService driverService;
    private DriverMapper driverMapper;

    public DriverController (DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @PostMapping
    public ResponseEntity<DriverResponse> driverRegister (@Valid @RequestBody DriverRequest driverRequest){
        log.info("DRIVER CONTROLLER > driverRegister > REQUEST > Driver: [{}]", driverRequest.name());
        var registeredDriver = this.driverService.driverRegister(driverMapper.driverRequestToDriver(driverRequest));
        log.info("DRIVER CONTROLLER > driverRegister > RESPONSE > STATUS: SUCESSO");
        return ResponseEntity.status(HttpStatus.CREATED).body(driverMapper.driverToDriverResponse(registeredDriver));
    }
}
