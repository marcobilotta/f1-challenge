package br.com.mlebilotta.f1challenge.application.domain.entity.enums;

public enum FunctionEnum {
    PILOTO,
    PILOTO_DE_TESTES;

    public static FunctionEnum validateFunction(String functionRequest) {
        for (FunctionEnum function : FunctionEnum.values()) {
            if (function.name().equalsIgnoreCase(functionRequest)) {
                return function;
            }
        }
        throw new RuntimeException("Função não é válida!");
    }
}

