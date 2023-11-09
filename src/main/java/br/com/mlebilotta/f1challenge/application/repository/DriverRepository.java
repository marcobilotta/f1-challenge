package br.com.mlebilotta.f1challenge.application.repository;

import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {
    Driver findByNameAndActive (String name, Boolean active);
}
