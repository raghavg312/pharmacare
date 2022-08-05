package com.pharmacy.suppliermanagement;

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

import java.util.Collections;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.pharmacy.suppliermanagement.Controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    public ApiInfo getInfo(){
        return new ApiInfo("Pharmacare - SupplierManagement Backend","This Project is developed to manage the Suppliers","1.0"
                ,"Terms Of Service",new Contact("Raghav","http://localhost:8761/","pharmacymanagement132@gmail.com")
                ,"License Of API","API licence URL", Collections.emptyList());
    }


}
