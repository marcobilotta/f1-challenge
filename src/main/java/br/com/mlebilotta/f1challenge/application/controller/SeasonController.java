package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.SeasonMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.SeasonRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.SeasonResponse;
import br.com.mlebilotta.f1challenge.application.domain.service.SeasonService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/v1/season")
public class SeasonController {

    private final SeasonService seasonService;
    private final SeasonMapper seasonMapper;

    public SeasonController (SeasonService seasonService, SeasonMapper seasonMapper) {
        this.seasonService = seasonService;
        this.seasonMapper = seasonMapper;
}
    @PostMapping
    public ResponseEntity<SeasonResponse> seasonRegister (@Valid @RequestBody SeasonRequest seasonRequest) {
        log.info("SeasonController > seasonRegister > Request > Season [{}]", seasonRequest.seasonYear());
        var seasonRegistered = this.seasonService.seasonRegister(seasonMapper.seasonRequestToSeason(seasonRequest));
        log.info("SeasonController > seasonRegister > Response > Status: SUCCESS > SeasonYear [{}], id [{}]", seasonRegistered.getSeasonYear(), seasonRegistered.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
