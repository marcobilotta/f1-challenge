package br.com.cadastropacientes.application.controller.response;

import br.com.cadastropacientes.application.model.Paciente;

public record PacienteResponse(
        String id,
        String nome,
        String sobrenome,
        String cpf,
        String endereco,
        Integer idade
) {
}
