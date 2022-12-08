package org.demicon.tech.task.d3.cloud.converter.toentities;

import org.demicon.tech.task.d3.cloud.entity.Street;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StreetModelToEntityConverter implements Converter<org.demicon.tech.task.d3.cloud.domain.model.Street, Street> {
    @Override
    public Street convert(org.demicon.tech.task.d3.cloud.domain.model.Street source) {
        return Street.builder()
                .name(source.getName())
                .number(Integer.parseInt(source.getNumber()))
                .build();
    }
}
