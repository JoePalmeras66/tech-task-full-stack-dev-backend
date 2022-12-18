package org.demicon.tech.task.d3.cloud.converter.toresponse;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RandomDataPageEntityToResponseConverter implements Converter<Page<RandomUser>, Page<RandomUserResponse>> {
    private final RandomDataEntityToResponseConverter randomDataEntityToResponseConverter;

    @Override
    public Page<RandomUserResponse> convert(Page<RandomUser> source) {
        return source.map(page -> this.randomDataEntityToResponseConverter.convert(page));
    }
}
