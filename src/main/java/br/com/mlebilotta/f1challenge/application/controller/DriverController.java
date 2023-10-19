package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/piloto")
public class DriverController {

    private final DriverService driverService;

    public DriverController (DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public Driver driverRegister (@RequestBody DriverRequest driverRequest){
        Driver driverRegistered = new Driver();
        driverRegistered = this.driverService.driverRegister(driverRequest.mapearDriverRequestParaDriver("eb113e07-4e26-4f1a-a384-8c6ca4bfa8e3"));
        return driverRegistered;
    }
}
