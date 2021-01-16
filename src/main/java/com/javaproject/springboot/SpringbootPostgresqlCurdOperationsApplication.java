package com.javaproject.springboot;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootPostgresqlCurdOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgresqlCurdOperationsApplication.class, args);
	}

	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.enableUrlTemplating(true)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				//.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.javaproject"))
				.build()
		//configuring metadata for the apis
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Employee Curd Operation APIs",
				"Basic Curd operation APIs with Employee Information, Spring boot with BD Postgresql",
				"1.0",
				"",
				new Contact("Aswanth Asokan","www.speridian.com", "aswanth.asokan@speridian.com"),
				"API License",
				"www.speridian.com",
				java.util.Collections.emptyList()
				
				);
	}
	
	
//    @Bean
//    public Docket api() {
//        //Adding Header
//        ParameterBuilder aParameterBuilder = new ParameterBuilder();
//        aParameterBuilder.name("Authorization")                 // name of header
//                         .modelRef(new ModelRef("string"))
//                         .parameterType("header")               // type - header
//                         .defaultValue("Basic dXNlcjpwYXNzd29yZA==")        // based64 of - user:password
//                         .required(true)                // for compulsory
//                         .build();
//        java.util.List<Parameter> aParameters = new ArrayList<>();
//        aParameters.add(aParameterBuilder.build());             // add parameter
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                                                      .apis(RequestHandlerSelectors.basePackage("com.javaproject"))
//                                                      .paths(PathSelectors.ant("/api/**"))
//                                                      .build()
//                                                      .pathMapping("")
//                                                      .globalOperationParameters(aParameters)
//                                                      .apiInfo(apiDetails());
//    }
	
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(basicAuthScheme()));
//   }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(basicAuthReference()))
//                .forPaths(PathSelectors.ant("/api/**"))
//                .build();
//    }
//
//    private SecurityScheme basicAuthScheme() {
//        return new BasicAuth("basicAuth");
//    }
//
//    private SecurityReference basicAuthReference() {
//        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
//    }
//
//}
}
