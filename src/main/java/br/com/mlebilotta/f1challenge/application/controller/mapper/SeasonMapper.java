package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.SeasonRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.SeasonResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    @Mapping(source = "id", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(source = "createdAt", target = "createdAt", defaultExpression = "java(java.time.LocalDate.now())")
    @Mapping(target = "lastModifiedAt", expression = "java(java.time.LocalDate.now())")
    Season seasonRequestToSeason(SeasonRequest seasonRequest);

    SeasonResponse seasonToSeasonResponse(Season season);
}
