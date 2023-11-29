package br.com.mlebilotta.f1challenge.application.repository;

import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, String> {

    Optional<Season> findBySeasonYear(Year seasonYear);
}
