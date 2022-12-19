package org.demicon.tech.task.d3.cloud.converter.toresponse;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class RandomDataStreamEntityToResponseConverter implements Converter<Stream<RandomUser>, Stream<RandomUserResponse>> {
    private final RandomDataEntityToResponseConverter randomDataEntityToResponseConverter;
    @Override
    public Stream<RandomUserResponse> convert(Stream<RandomUser> source) {
        return source.map(item -> this.randomDataEntityToResponseConverter.convert(item));
    }
}
