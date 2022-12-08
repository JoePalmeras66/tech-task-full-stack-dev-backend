package org.demicon.tech.task.d3.cloud.converter.toentities;

import org.demicon.tech.task.d3.cloud.entity.Timezone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TimezoneModelToEntityConverter implements Converter<org.demicon.tech.task.d3.cloud.domain.model.Timezone, Timezone> {
    @Override
    public Timezone convert(org.demicon.tech.task.d3.cloud.domain.model.Timezone source) {
        return Timezone.builder()
                .timezone_offset(source.getOffset())
                .description(source.getDescription())
                .build();
    }
}
