package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.CircuitMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.CircuitRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.CircuitResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Circuit;
import br.com.mlebilotta.f1challenge.application.domain.service.CircuitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/v1/circuit")
public class CircuitController {
    private final CircuitService circuitService;
    private final CircuitMapper circuitMapper;
    public CircuitController(CircuitService circuitService, CircuitMapper circuitMapper) {
        this.circuitService = circuitService;
        this.circuitMapper = circuitMapper;
    }
    @PostMapping
    public ResponseEntity<CircuitResponse> circuitRegister(@Valid @RequestBody CircuitRequest circuitRequest) {
        var circuitRegistered = this.circuitService.circuitRegister(circuitMapper.circuitRequestToCircuit(circuitRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
