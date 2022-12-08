package org.demicon.tech.task.d3.cloud.converter.tomodels;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.Result;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ResultListEntityToModelConverter implements Converter<List<RandomUser>, List<Result>> {
    private final ResultEntityToModelConverter resultEntityToModelConverter;

    @Override
    public List<Result> convert(List<RandomUser> source) {
        return source.stream()
                .map(result -> resultEntityToModelConverter.convert(result))
                .collect(Collectors.toList());
    }
}
