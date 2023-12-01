package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Circuit;
import br.com.mlebilotta.f1challenge.application.repository.CircuitRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.circuit.CircuitAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CircuitService {
    private final CircuitRepository circuitRepository;
    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }
    public Optional<Circuit> circuitRegister(Circuit circuit) {
        var circuitResult = this.circuitRepository.findByNameAndActive(circuit.getName(), circuit.getActive());
        if (circuitResult.isPresent()) {
            throw new CircuitAlreadyExistsException("Circuito já existente na base de dados!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Circuito já cadastrado"));
        }
        this.circuitRepository.save(circuit);
        return circuitResult;
    }
}
