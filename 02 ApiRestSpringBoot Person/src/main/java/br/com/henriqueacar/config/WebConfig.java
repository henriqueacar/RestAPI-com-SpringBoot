package br.com.henriqueacar.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.henriqueacar.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");
	//Conversor para YAML
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		//Content negotiation via Extension
		//Ex: http://localhost:8080/person.xml
		configurer.favorParameter(false)
			.ignoreAcceptHeader(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_YAML);
		
		//Content negotiation via QUERY Parameter
		//Ex: http://localhost:8080/person?mediaType=json
		//Nao funciona com os outros dois metodos ativos, retirando o metodo via HEADER funciona
		configurer/*.favorPathExtension(true)*/
			.favorParameter(true)
			.parameterName("mediaType")
			.ignoreAcceptHeader(true)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
		
		//Content negotiation via HEADER
		//Ex: Criar KEY Accept e VALUE application/xml ou json
		configurer.favorPathExtension(true)
			.favorParameter(false)
			.ignoreAcceptHeader(false)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
				
		
	}
}
