package com.climbing.zone.configuration;

import com.google.common.base.Predicates;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //.apis(RequestHandlerSelectors.basePackage("spring.auxietre.com"))
    //.apis(RequestHandlerSelectors.any())
    @Bean
    public Docket api() {
        System.out.println("passe dans swagger");
        System.out.println("--------------url trouvee----------"+RequestHandlerSelectors.basePackage("spring.auxietre.com"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .host("spring.auxietre.com");

    }


    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CLIMBING ZONE API ")
                .description("This api help climbers to win cards game")
                .version("1.0")
                .build();
    }
//    // Only select apis that matches the given Predicates.
//    private Predicate<String> paths() {
//// Match all paths except /error
//        return (Predicate<String>) Predicates.and(
//                PathSelectors.regex("/customer.*"),
//                Predicates.not(PathSelectors.regex("/error.*")))
//                ;
//    }
}
