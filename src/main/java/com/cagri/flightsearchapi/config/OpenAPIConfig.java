package com.cagri.flightsearchapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    private String url = "http://localhost:8080";


    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(url);
        devServer.setDescription("Server URL in Development environment");


        Contact contact = new Contact();
        contact.setEmail("cuneytcagriyilmaz@gmail.com");
        contact.setName("Cüneyt Çağrı YILMAZ");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Flight Search API")
                .version("1.0")
                .contact(contact)
                .description("API for flight search application.").termsOfService("cuneytcagriyilmaz@gmail.com")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
