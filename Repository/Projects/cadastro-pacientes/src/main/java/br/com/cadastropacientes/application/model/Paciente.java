package br.com.cadastropacientes.application.model;

import br.com.cadastropacientes.application.controller.response.PacienteResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "paciente")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Paciente {

    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private Integer idade;

    public PacienteResponse mapearPacienteParaPacienteResponse(){
        PacienteResponse pacienteResponse = new PacienteResponse(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.endereco,
                this.idade
        );
        return pacienteResponse;

    }
}
