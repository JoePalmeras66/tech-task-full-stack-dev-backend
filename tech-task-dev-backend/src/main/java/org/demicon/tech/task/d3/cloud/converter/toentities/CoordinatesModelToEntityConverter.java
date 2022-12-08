package org.demicon.tech.task.d3.cloud.converter.toentities;

import org.demicon.tech.task.d3.cloud.entity.Coordinates;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesModelToEntityConverter implements Converter<org.demicon.tech.task.d3.cloud.domain.model.Coordinates, Coordinates> {
    @Override
    public Coordinates convert(org.demicon.tech.task.d3.cloud.domain.model.Coordinates source) {
        return Coordinates.builder()
                .latitute(source.getLatitude())
                .longitute(source.getLongitude())
                .build();
    }
}
