package br.com.cadastropacientes.application.repository;

import br.com.cadastropacientes.application.model.Paciente;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
