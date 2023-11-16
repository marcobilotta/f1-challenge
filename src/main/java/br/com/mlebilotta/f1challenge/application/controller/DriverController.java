package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.DriverMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.service.DriverService;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/driver")
@Log4j2
@Tag(name = "Driver")
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    public DriverController (DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @Operation(summary = "Create a new driver")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DriverRequest.class)
            )
            })
    @ApiResponses(value = {
            @ApiResponse(
                responseCode = "200",
                description = "Driver created with success",
                content = {@Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = DriverResponse.class)
                )}
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Driver already exists",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )}
            )
    })
    //@Parameter(schema = @Schema(contentSchema = DriverRequest.class))
    @PostMapping
    public ResponseEntity<DriverResponse> driverRegister (@Valid @RequestBody DriverRequest driverRequest){
        log.info("DRIVER CONTROLLER > driverRegister > REQUEST > Driver: [{}]", driverRequest.name());
        var registeredDriver = this.driverService.driverRegister(driverMapper.driverRequestToDriver(driverRequest));
        log.info("DRIVER CONTROLLER > driverRegister > RESPONSE > STATUS: SUCESSO");
        return ResponseEntity.status(HttpStatus.CREATED).body(driverMapper.driverToDriverResponse(registeredDriver));
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

    @Operation(
            summary = "Delete Driver",
            description = "Delete the driver from the database using the provided ID"
    )
    @Parameter(
            name = "id",
            description = "id from database to delete the driver",
            example = "7c63d44e-9eb9-4136-9e98-33aca18a87d2"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<DriverResponse> driverDeleteById (@PathVariable String id) {
        Driver driver = this.driverService.driverDeleteById(id);
        log.info("DriverController > driverDeleteById > Response > Status: SUCESS");
        return ResponseEntity.status(HttpStatus.OK).body(driverMapper.driverToDriverResponse(driver));
        }
}
