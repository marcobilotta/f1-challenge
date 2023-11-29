package br.com.mlebilotta.f1challenge.application.controller;

import br.com.mlebilotta.f1challenge.application.controller.mapper.SeasonMapper;
import br.com.mlebilotta.f1challenge.application.controller.request.SeasonRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.SeasonResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import br.com.mlebilotta.f1challenge.application.domain.service.SeasonService;
import br.com.mlebilotta.f1challenge.infrastructure.exception.response.ErrorFieldsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Season")
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

    @Operation(summary = "Create a new season")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SeasonRequest.class)
                    )}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Season created with success",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SeasonResponse.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "attribute outside the expected standard",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorFieldsResponse.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "SeasonYear already registered in the database",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )}
            )
    })
    @PostMapping
    public ResponseEntity<SeasonResponse> seasonRegister(@Valid @RequestBody SeasonRequest seasonRequest) {
        log.info("SeasonController > seasonRegister > Request > Season [{}]", seasonRequest.seasonYear());
        var seasonRegistered = this.seasonService.seasonRegister(seasonMapper.seasonRequestToSeason(seasonRequest));
        log.info("SeasonController > seasonRegister > Response > Status: SUCCESS > SeasonYear [{}], id [{}]", seasonRegistered.getSeasonYear(), seasonRegistered.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

   /* @GetMapping("{/seasonYear}")
    public ResponseEntity<SeasonResponse> seasonSearchByYear(@Valid @PathVariable String seasonYear) {
        Optional<Season> season = this.seasonService.seasonSearchBySeasonYear(seasonYear);
        return ResponseEntity.status(HttpStatus.OK).body(seasonMapper.seasonToSeasonResponse(season));
    }*/
}
