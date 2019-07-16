package com.ventura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
  
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors
                  .basePackage("com.ventura.controller"))              
          .paths(PathSelectors.regex("/.*"))                          
          .build().apiInfo(apiEndPointsInfo());                                          
    }
    
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Ventura REST API")
            .description("Portal for analyzing Demand and Supply in Cisco")
            .contact(new Contact("Tarun Malhotra", null, "tarun.malhotra@lntinfotech.com"))
            .version("1.0.0")
            .build();
    }
}
