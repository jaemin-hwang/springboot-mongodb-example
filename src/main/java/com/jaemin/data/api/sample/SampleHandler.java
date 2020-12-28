package com.jaemin.data.api.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleHandler {

    private final SampleService sampleService;

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_GUEST')")
    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("]-----] SampleHandler::findAllByTitle call [-----[ ");
        Integer page = request.queryParam("page").isPresent() ? Integer.parseInt(request.queryParam("page").get()) - 1 : 0;
        Integer size = request.queryParam("size").isPresent() ? Integer.parseInt(request.queryParam("size").get()) : 20;
        return request.principal()
                .flatMap(p -> Mono.just(p.getName()))
                .flatMap(memberId -> sampleService.findAll(page, size, memberId))
                .flatMap(result -> ok().body(fromValue(result)))
                .switchIfEmpty(notFound().build());

    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_GUEST')")
    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("]-----] SampleHandler::findById call [-----[ ");
        String id = request.pathVariable("id");
        return request.principal()
                .flatMap(p -> Mono.just(Long.parseLong(p.getName())))
                .flatMap(memberId -> sampleService.findById(id, memberId))
                .flatMap(sampleView -> ok().body(fromValue(sampleView)))
                .switchIfEmpty(notFound().build());

    }
}
