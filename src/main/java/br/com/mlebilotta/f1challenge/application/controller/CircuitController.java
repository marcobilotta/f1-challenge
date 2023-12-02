package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.CircuitMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.CircuitRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.CircuitResponse;
import br.com.mlebilotta.f1challenge.application.domain.service.CircuitService;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorFieldsResponse;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Circuit")
@Log4j2
@RestController
@RequestMapping("/v1/circuit")
public class CircuitController {
    private final CircuitService circuitService;
    private final CircuitMapper circuitMapper;
    public CircuitController(CircuitService circuitService, CircuitMapper circuitMapper) {
        this.circuitService = circuitService;
        this.circuitMapper = circuitMapper;
    }

    @Operation(description = "Create a new Circuit")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CircuitRequest.class)
            )
            })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Circuit created with success",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CircuitResponse.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Some CircuitRequest field is not up to expected standards",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorFieldsResponse.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Circuit already exists",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )}
            )
    })
    @PostMapping
    public ResponseEntity<CircuitResponse> circuitRegister(@Valid @RequestBody CircuitRequest circuitRequest) {
        log.info("CircuitController > circuitRegister > Request > Circuit [{}]", circuitRequest.name());
        var circuitRegistered = this.circuitService.circuitRegister(circuitMapper.circuitRequestToCircuit(circuitRequest));
        log.info("CircuitController > circuitRegister > Response > Status: SUCCESS > Circuit name [{}], id [{}]", circuitRegistered.getName(), circuitRegistered.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
