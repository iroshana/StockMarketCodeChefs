package codechef.stockmarket.codechef;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi()
    {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("codechef.stockmarket.restcontroller"))
                .paths(regex("/.*")).build().apiInfo(metaData());
    }

    private ApiInfo metaData()
    {

        ApiInfo apiInfo = new ApiInfo("Stock Market Game", "Spring Boot REST API for Stock Market ", "1.0",
                "Terms of service",
                new Contact("Code Chefs (Developer By Ravindu)", "", "ravinduiroshana123@gmail.com"),
                " License Version 1.0", "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
