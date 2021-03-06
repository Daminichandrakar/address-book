package com.bridgelabz.addressbook.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Purpose : To configure swagger for addressBook application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Purpose : This method is used to specify the swagger to which API(Application Programming Interface)
     * to show on Swagger UI(User Interface) console
     *
     * @return the docket link which has the information about API(Application Programming Interface)
     */
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Address Book")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.addressbook.controller"))
                .build();
    }

    /**
     * Purpose : This method is used to add extra datas which will give user a proper idea about
     * the API(Application Programming Interface) information in the Swagger UI(User Interface) console
     *
     * @return the swagger API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("AddressBook Application")
                .description("AddressBook Rest API")
                .termsOfServiceUrl("https://github.com/Daminichandraka")
                .license("License")
                .licenseUrl("https://github.com/Daminichandraka")
                .version("1.0")
                .build();
    }
}
