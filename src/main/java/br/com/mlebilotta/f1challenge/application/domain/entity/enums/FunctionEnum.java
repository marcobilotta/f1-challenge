package br.com.mlebilotta.f1challenge.application.domain.entity.enums;

import br.com.mlebilotta.f1challenge.infrastructure.exception.driver.InvalidFunctionException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

@Log4j2
public enum FunctionEnum {
    PILOTO,
    PILOTO_DE_TESTES;

    public static FunctionEnum validateFunction(String functionRequest) {
        for (FunctionEnum function : FunctionEnum.values()) {
            if (function.name().equalsIgnoreCase(functionRequest)) {
                return function;
            }
        }
        log.error("DRIVER CONTROLLER > validateFunction > Função [{}] não permitida", functionRequest);
        throw new InvalidFunctionException("Função não permitida!", HttpStatus.UNPROCESSABLE_ENTITY, new Throwable("Função não descrita na lista padrão do App"));
    }
}

