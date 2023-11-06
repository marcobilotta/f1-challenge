package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(source = "id", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "active", constant = "true")
    Driver driverRequestToDriver (DriverRequest driverRequest);

    DriverResponse driverToDriverResponse (Driver driver);

}
