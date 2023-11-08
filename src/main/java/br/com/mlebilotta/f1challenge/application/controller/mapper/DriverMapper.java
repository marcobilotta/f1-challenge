package br.com.mlebilotta.f1challenge.application.controller.mapper;

import br.com.mlebilotta.f1challenge.application.controller.request.DriverRequest;
import br.com.mlebilotta.f1challenge.application.controller.response.DriverResponse;
import br.com.mlebilotta.f1challenge.application.domain.entity.Driver;
import br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum;
import lombok.ToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(source = "id", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "active", constant = "true")
    @Mapping(source = "createdAt", target = "createdAt", defaultExpression = "java(java.time.LocalDate.now())")
    @Mapping(target = "lastModifiedAt", expression = "java(java.time.LocalDate.now())")
    @Mapping(source = "function", target = "function", qualifiedByName = "validateFunction(driverRequest.function)")
    Driver driverRequestToDriver (DriverRequest driverRequest);
        @Named("validateFunction(driverRequest.function)")
        default FunctionEnum validateFunction(String function) {
            return FunctionEnum.validateFunction(function);
        }

    DriverResponse driverToDriverResponse (Driver driver);


}
//expression = "java(br.com.mlebilotta.f1challenge.application.domain.entity.enums.FunctionEnum.validateFunction(driverRequest.function)