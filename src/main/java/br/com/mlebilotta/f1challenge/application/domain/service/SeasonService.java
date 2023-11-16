package br.com.mlebilotta.f1challenge.application.domain.service;

import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import br.com.mlebilotta.f1challenge.application.repository.SeasonRepository;
import br.com.mlebilotta.f1challenge.infrastructure.exception.season.SeasonAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }
    public Season seasonRegister(Season season) {
        var seasonResult = this.seasonRepository.findBySeasonYear(season.getSeasonYear());
        if (seasonResult.isPresent()) {
            throw new SeasonAlreadyExistsException("Session já existente!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Session Year já registrada na base de dados"));
        }
        return this.seasonRepository.save(season);
    }
}
