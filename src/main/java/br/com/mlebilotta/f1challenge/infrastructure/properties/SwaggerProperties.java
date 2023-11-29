package br.com.mlebilotta.f1challenge.infrastructure.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "swagger.properties")
@Getter
public class SwaggerProperties {

    private String title;
    private String description;
    private String version;

}
