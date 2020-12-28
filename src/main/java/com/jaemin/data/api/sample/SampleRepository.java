package com.jaemin.data.api.sample;

import com.jaemin.data.api.sample.model.Sample;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SampleRepository extends ReactiveMongoRepository<Sample, String> {
    Flux<Sample> findAllByTitle(String title, Pageable page);

    Mono<Long> countAllByTitle(String title);

    Mono<Sample> findByTitleContains(String title);

}