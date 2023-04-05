package com.product.config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
//@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	public springfox.documentation.spring.web.plugins.Docket apis(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}
	@Bean
	public Docket apis(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Shopping Interface - Spring Boot Swagger Configuration ")
				.description("\"Swagger Configuration for application \"")
				.version("1.1.0")
				.license("Apache 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}
}
