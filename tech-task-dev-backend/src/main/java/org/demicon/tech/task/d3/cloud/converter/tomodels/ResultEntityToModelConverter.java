package org.demicon.tech.task.d3.cloud.converter.tomodels;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.Result;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResultEntityToModelConverter implements Converter<RandomUser, Result> {
    private final NameEntityToModelConverter nameEntityToModelConverter;
    private final LocationEntityToModelConverter locationEntityToModelConverter;

    @Override
    public Result convert(RandomUser source) {
        Result result = new Result();
        result.setGender(source.getGender());
        result.setName(nameEntityToModelConverter.convert(source.getName()));
        result.setLocation(locationEntityToModelConverter.convert(source.getLocation()));
        result.setEmail(source.getEmail());
        return result;
    }
}
