package com.jaemin.data.api.sample;

import com.jaemin.data.api.sample.model.Sample;
import com.jaemin.data.api.sample.view.SampleView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    public Mono<PageImpl> findAll(Integer page, Integer size, String memberId) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        return Mono.zip(
                (data) -> {
                    log.debug("]-----] SampleHandler::findAllByTitle memberId [-----[ {}", memberId);
                    log.debug("]-----] SampleHandler::findAllByTitle data [-----[ {}", data);
                    List<SampleView> sampleViews = (List<SampleView>) data[0];
                    Long totalCount = (Long) data[1];
                    return new PageImpl<>(sampleViews, pageable, totalCount);
                },
                sampleRepository.findAllByTitle("my test title", pageable).map(this::sampleEntityToView).collectList(),
                sampleRepository.countAllByTitle("my test title")
        ).cast(PageImpl.class);
    }

    public Mono<SampleView> findById(String id, Long memberId) {
        return sampleRepository.findById(id).map(this::sampleEntityToView);
    }

    public SampleView sampleEntityToView(Sample sample) {
        log.debug("]-----] SampleHandler::sampleEntityToView sample [-----[ {}", sample);
        return SampleView.builder()
                .id(sample.getId())
                .active(sample.getActive())
                .createdAt(sample.getCreatedAt())
                .createdId(sample.getCreatedId())
                .contents(sample.getContents())
                .title(sample.getTitle())
                .status(sample.getStatus())
                .build();
    }

}
