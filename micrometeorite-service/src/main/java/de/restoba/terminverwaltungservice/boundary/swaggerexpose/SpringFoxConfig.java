package de.restoba.terminverwaltungservice.boundary.swaggerexpose;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.restoba.terminverwaltungservice.boundary"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Terminverwaltung REST API",
                "Verwaltungsystem für Termine in Hausarztpraxen für COVID-19-Impftermine.",
                "1.0.0",
                "",
                new Contact("Maximilian Gruber", "", "maximiliangruber91@gmail.com"),
                "", "", Collections.emptyList());
    }
}
