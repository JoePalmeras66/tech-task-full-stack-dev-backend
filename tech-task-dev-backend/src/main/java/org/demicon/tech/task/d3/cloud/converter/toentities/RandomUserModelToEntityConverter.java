package org.demicon.tech.task.d3.cloud.converter.toentities;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.RandomUserData;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomUserModelToEntityConverter implements Converter<RandomUserData, RandomUser> {
    private final NameModelToEntityConverter nameModelToEntityConverter;
    private final LocationModelToEntityConverter locationModelToEntityConverter;

    @Override
    public RandomUser convert(RandomUserData source) {
        return RandomUser.builder()
                .gender(source.getResults().get(0).getGender())
                .name(nameModelToEntityConverter.convert(source.getResults().get(0).getName()))
                .location(locationModelToEntityConverter.convert(source.getResults().get(0).getLocation()))
                .email(source.getResults().get(0).getEmail())
                .build();
    }
}
