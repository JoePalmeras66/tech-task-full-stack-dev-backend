package org.demicon.tech.task.d3.cloud.converter.toresponse;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.domain.model.response.page.PageInfo;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RandomDataPageEntityToResponseConverter implements Converter<Page<RandomUser>, PageInfo<RandomUserResponse>> {
    private final RandomDataStreamEntityToResponseConverter randomDataStreamEntityToResponseConverter;

    @Override
    public PageInfo<RandomUserResponse> convert(Page<RandomUser> source) {
        return new PageInfo<>(
            this.randomDataStreamEntityToResponseConverter.convert(source.get())
                    .collect(Collectors.toList()),
            source.getNumber(),
            source.getSize(),
            source.getTotalPages(),
            source.getTotalElements()
        );
    }
}