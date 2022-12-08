package org.demicon.tech.task.d3.cloud.converter.toresponse;

import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RandomDataEntityToResponseConverter implements Converter<RandomUser, RandomUserResponse> {
    @Override
    public RandomUserResponse convert(RandomUser source) {
        return new RandomUserResponse(source.getName().getFirst(),
                                      source.getName().getLast(),
                                      source.getGender(),
                                      source.getEmail());
    }
}