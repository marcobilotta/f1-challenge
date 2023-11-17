package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import br.com.mlebilotta.f1challenge.application.repository.SeasonRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.season.SeasonAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }
    public Season seasonRegister(Season season) {
        log.info("SeasonService > seasonRegister > Request > Season [{}]", season.getSeasonYear());
        var seasonResult = this.seasonRepository.findBySeasonYear(season.getSeasonYear());
        if (seasonResult.isPresent()) {
            throw new SeasonAlreadyExistsException("Session já existente!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Ano já registrado na base de dados"));
        }
        log.info("SeasonService > seasonRegister > Response > Status: SUCCESS > SeasonYear [{}], id [{}]", season.getSeasonYear(), season.getId());
        return this.seasonRepository.save(season);
    }
}
