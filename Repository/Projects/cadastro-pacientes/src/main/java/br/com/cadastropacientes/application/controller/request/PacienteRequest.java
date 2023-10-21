package br.com.cadastropacientes.application.controller.request;

import br.com.cadastropacientes.application.model.Paciente;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

import static java.util.UUID.randomUUID;

public record PacienteRequest(

        @Length(max = 5, message = "{validation.paciente.nome.message}")
        @NotEmpty
        String nome,
        String sobrenome,
        String cpf,
        String endereco,
        Integer idade
) {

    public Paciente mapearPacienteRequestParaPaciente(String id){
        return Paciente.builder()
                .id(validarId(id))
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .cpf(this.cpf)
                .endereco(this.endereco)
                .build();

 //       SEM UTILIZAÇÃO DA ANOTAÇÃO @BUILDER DO LOMBOK
//        Paciente paciente = new Paciente();
//        paciente.setId(validarId(id));
//        paciente.setNome(this.nome);
//        paciente.setSobrenome(this.sobrenome);
//        paciente.setCpf(this.cpf);
//        paciente.setEndereco(this.endereco);
//        paciente.setIdade(this.idade);
//        return paciente;
    }

    private String validarId(String id){
        if (Objects.isNull(id)){
            return randomUUID().toString();
        }
        return id;
    }
}
