package com.jaemin.data.api.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class SampleRouter {

    @Bean
    public RouterFunction<ServerResponse> sampleRouterFunction(SampleHandler handler) {

        return RouterFunctions
                .nest(path("/api/v1/sample"),
                        route(GET("").and(accept(APPLICATION_JSON)), handler::findAll)
                                .andRoute(GET("/{id}").and(accept(APPLICATION_JSON)), handler::findById)
                );
    }
}
