package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Circuit;
import br.com.mlebilotta.f1challenge.application.repository.CircuitRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.circuit.CircuitAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CircuitService {
    private final CircuitRepository circuitRepository;
    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }
    public Circuit circuitRegister(Circuit circuit) {
        log.info("CircuitService > circuitRegister > Request > Circuit [{}]", circuit.getName());
        var circuitResult = this.circuitRepository.findByNameAndActive(circuit.getName(), circuit.getActive());
        if (circuitResult.isPresent()) {
            throw new CircuitAlreadyExistsException("Circuito já existente na base de dados!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Circuito já cadastrado"));
        }
        this.circuitRepository.save(circuit);
        log.info("CircuitService > circuitRegister > Response > Status: SUCCESS > Circuit name [{}], id [{}]", circuit.getName(), circuit.getId());
        return circuit;
    }
}
