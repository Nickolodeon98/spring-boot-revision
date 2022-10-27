package com.example.revision.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // Swagger V3 를 사용한다. (Swagger V2 는 DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true) // HTTP 응답 메시지 방식을 디폴트 방식으로 한다.
                .select() // api 를 선택할 준비를 한다.
                .apis(RequestHandlerSelectors.any()) // 컨트롤러는 request handler 이기도 한 것이다. 어차피 패키지가 하나이므로 any를 사용한다.
                .paths(PathSelectors.any()) // 모든 api 경로를 다 선택하겠다는 말이다.
                .build();
    }
}
