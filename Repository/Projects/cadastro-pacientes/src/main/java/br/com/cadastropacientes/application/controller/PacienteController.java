package br.com.cadastropacientes.application.controller;

import br.com.cadastropacientes.application.controller.request.PacienteRequest;
import br.com.cadastropacientes.application.controller.response.PacienteResponse;
import br.com.cadastropacientes.application.model.Paciente;
import br.com.cadastropacientes.application.service.PacienteService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/paciente")
@Log4j2
@ConfigurationProperties("paciente")
public class PacienteController {


    private String nome;
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponse> cadastrarPaciente(@Valid @RequestBody PacienteRequest pacienteRequest) {
        log.info("PACIENTE CONTROLLER - cadastrarPaciente - REQUEST - paciente: [{}]", nome);
        Paciente pacienteCadastrado = new Paciente();
        pacienteCadastrado = this.pacienteService.cadastrarPaciente(pacienteRequest.mapearPacienteRequestParaPaciente(null));
        log.info("PACIENTE CONTROLLER - cadastrarPaciente - RESPONSE - STATUS: SUCESSO");
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCadastrado.mapearPacienteParaPacienteResponse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> consultarPacientePorId(@PathVariable String id){
        Optional<Paciente> paciente = this.pacienteService.consultarPacientePorId(id);
        if (paciente.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(paciente.get().mapearPacienteParaPacienteResponse());
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarPacientePorId(@RequestHeader String id){
        this.pacienteService.deletarPacientePorId(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public PacienteResponse atualizarPaciente(
            @RequestBody PacienteRequest pacienteRequest,
            @RequestHeader String id
    ){
        return this.pacienteService.atualizarPaciente(pacienteRequest, id);
    }

}
