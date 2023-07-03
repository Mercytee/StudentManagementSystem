package com.basics.studentmanagementsystem.config;

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

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.basics.studentmanagementsystem"))
                .paths(PathSelectors.ant("/api/**"))
                .build().apiInfo(apiInfo());

    }
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("One All Market API")
                    .description("One All Market API")
                    .contact(new Contact("Hitrac Developers", "https://hitrac.co.zw", "infor@hitrac.co.zw"))
                    .license("HITRAC")
                    .licenseUrl("https://hitrac.co.zw/OneAllMarket/LICENSE")
                    .version("1.0.0")
                    .build();
        }



}
