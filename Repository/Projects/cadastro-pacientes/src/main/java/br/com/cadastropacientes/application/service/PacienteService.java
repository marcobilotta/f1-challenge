package br.com.cadastropacientes.application.service;

import br.com.cadastropacientes.application.controller.request.PacienteRequest;
import br.com.cadastropacientes.application.controller.response.PacienteResponse;
import br.com.cadastropacientes.application.model.Paciente;
import br.com.cadastropacientes.application.repository.PacienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }
    public Paciente cadastrarPaciente(Paciente paciente){
        log.info("PACIENTE SERVICE - cadastrarPaciente - paciente [{}]", paciente);
        this.pacienteRepository.save(paciente);
        return paciente;
    }

    public PacienteResponse atualizarPaciente(PacienteRequest pacienteRequest, String id){
//        //PacienteResponse pacienteResponse = this.consultarPacientePorId(id);
//
//        if (Objects.isNull(pacienteResponse.id())) {
//            return pacienteResponse;
//        }
//        Paciente paciente = new Paciente();
//        paciente = pacienteRequest.mapearPacienteRequestParaPaciente(id);
//        this.pacienteRepository.save(paciente);
//        return paciente.mapearPacienteParaPacienteResponse();
        return new PacienteResponse(null,null,null,null,null,null);
    }
    public Optional<Paciente> consultarPacientePorId(String id){
        return this.pacienteRepository.findById(id);
    }

    public void deletarPacientePorId(String id){
        this.pacienteRepository.deleteById(id);
    }


}
