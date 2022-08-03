package com.pharmacy.usermanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.pharmacy.usermanagement.Controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    public ApiInfo getInfo(){
        return new ApiInfo("Pharmacare - UserManagement Backend","This Project is developed to manage the Users","1.0"
                ,"Terms Of Service",new Contact("Raghav","","pharmacymanagement132@gmail.com")
                ,"License Of API","API licence URL", Collections.emptyList());
    }
}