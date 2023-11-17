package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.SeasonRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.SeasonResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Year;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(source = "seasonYear", target = "seasonYear", qualifiedByName = "formatSeasonYear")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "lastModifiedAt", expression = "java(java.time.LocalDate.now())")
    Season seasonRequestToSeason(SeasonRequest seasonRequest);
        @Named("formatSeasonYear")
        default Year formatSeasonYear(String seasonYear) {
            DateTimeFormatter standardYearFormat = DateTimeFormatter.ofPattern("yyyy");
            return Year.parse(seasonYear, standardYearFormat);
        }

    SeasonResponse seasonToSeasonResponse(Season season);
}
