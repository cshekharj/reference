package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);	
	
	@Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.debug("--Application Started--");
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Springfox petstore API")
            .description("description")
            .contact(new Contact("name", "url", "email"))
            .license("Apache License Version 2.0")
            .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
            .version("2.0")
            .build();
    }
}
