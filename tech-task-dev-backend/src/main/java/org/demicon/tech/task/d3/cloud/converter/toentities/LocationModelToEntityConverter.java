package org.demicon.tech.task.d3.cloud.converter.toentities;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationModelToEntityConverter implements Converter<org.demicon.tech.task.d3.cloud.domain.model.Location, Location> {
    private final CoordinatesModelToEntityConverter coordinatesModelToEntityConverter;
    private final StreetModelToEntityConverter streetModelToEntityConverter;
    private final TimezoneModelToEntityConverter timezoneModelToEntityConverter;

    @Override
    public Location convert(org.demicon.tech.task.d3.cloud.domain.model.Location source) {
        return Location.builder()
                .coordinates(coordinatesModelToEntityConverter.convert(source.getCoordinates()))
                .city(source.getCity())
                .country(source.getCountry())
                .postcode(source.getPostcode())
                .state(source.getState())
                .street(streetModelToEntityConverter.convert(source.getStreet()))
                .timezone(timezoneModelToEntityConverter.convert(source.getTimezone()))
                .build();
    }
}
