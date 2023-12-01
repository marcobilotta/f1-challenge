package br.com.mlebilotta.f1challenge.application.repository;

import br.com.mlebilotta.f1challenge.application.domain.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, String> {

    Optional<Circuit> findByNameAndActive(String name, Boolean active);

}
