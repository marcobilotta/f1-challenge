package br.com.mlebilotta.f1challenge.infrastructure.configuration;

import br.com.mlebilotta.f1challenge.infrastructure.properties.SwaggerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SwaggerConfiguration {

    private final SwaggerProperties swaggerProperties;

    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI().info(builderInfo());
    }

    private Info builderInfo() {
        return new Info()
                .description(swaggerProperties.getDescription())
                .title(swaggerProperties.getTitle())
                .version(swaggerProperties.getVersion());
    }
}
