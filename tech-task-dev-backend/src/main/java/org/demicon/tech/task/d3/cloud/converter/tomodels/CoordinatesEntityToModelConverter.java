package org.demicon.tech.task.d3.cloud.converter.tomodels;

import org.demicon.tech.task.d3.cloud.entity.Coordinates;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesEntityToModelConverter implements Converter<Coordinates, org.demicon.tech.task.d3.cloud.domain.model.Coordinates> {
    @Override
    public org.demicon.tech.task.d3.cloud.domain.model.Coordinates convert(Coordinates source) {
        org.demicon.tech.task.d3.cloud.domain.model.Coordinates coordinates = new org.demicon.tech.task.d3.cloud.domain.model.Coordinates();
        coordinates.setLatitude(source.getLatitute());
        coordinates.setLongitude(source.getLongitute());
        return coordinates;
    }
}
