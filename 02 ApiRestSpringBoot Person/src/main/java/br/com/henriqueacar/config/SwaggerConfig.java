package br.com.henriqueacar.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String PERSON_TAG = "Person Service";
	public static final String BOOK_TAG = "Book Service";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.henriqueacar"))
				.paths(PathSelectors.any())
				.build()
				.tags(new Tag(PERSON_TAG, "Person API"), new Tag(BOOK_TAG, "Book API"))
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API RESTful com Springboot 2.1.3", 
						   "Esta é uma API RESTful desenvolvida como projeto de estudos do dev @henriqueacar, utilizando o curso REST API's RESTFul do 0 à AWS com Spring Boot 2.x e Docker como base."
						   +"\nNesta API, são utilizadas as tecnologias Dozer Converter, Padrão Value Object, testes automatizados com JUnit, suporte a Migrations com Flyway, Content Negotiation e outras.", 
						   "Versão 1", 
						   "URL dos termos de serviço da API", 
						   new Contact("Henrique de Almeida Cardoso", "http://localhost:8080/", "henrique_acar@hotmail.com"),
						   "Termos de Licença", 
						   "URL dos termos de licença", 
						   Collections.emptyList());
	}
}