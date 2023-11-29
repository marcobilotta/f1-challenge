package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(source = "id", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "active", constant = "true")
    @Mapping(source = "createdAt", target = "createdAt", defaultExpression = "java(java.time.LocalDate.now())")
    @Mapping(target = "lastModifiedAt", expression = "java(java.time.LocalDate.now())")
    @Mapping(source = "driverFunction", target = "driverFunction", qualifiedByName = "validateFunction")
    Driver driverRequestToDriver (DriverRequest driverRequest);
        @Named("validateFunction")
        default FunctionEnum validateFunction(String function) {
            return FunctionEnum.validateFunction(function);
        }

    @Mapping(target = "driverFunction", expression = "java(driver.getDriverFunction().name())")
    DriverResponse driverToDriverResponse (Driver driver);
}
