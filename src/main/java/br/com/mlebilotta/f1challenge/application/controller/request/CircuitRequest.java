package br.com.mlebilotta.f1challenge.application.controller.request;

public record CircuitRequest(
        String name,
        String location,
        String country,
        String url
) {
}
