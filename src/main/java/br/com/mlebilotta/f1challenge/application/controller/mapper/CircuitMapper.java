package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.CircuitRequest;
import br.com.mlebilotta.f1challenge.application.domain.entity.Circuit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CircuitMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "lastModifiedAt", expression = "java(java.time.LocalDate.now())")
    Circuit circuitRequestToCircuit(CircuitRequest circuitRequest);

}
