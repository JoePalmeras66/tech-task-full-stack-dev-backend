package org.demicon.tech.task.d3.cloud.converter.tomodels;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationEntityToModelConverter implements Converter<Location, org.demicon.tech.task.d3.cloud.domain.model.Location> {
    private final CoordinatesEntityToModelConverter coordinatesEntityToModelConverter;
    private final StreetEntityToModelConverter streetEntityToModelConverter;
    private final TimezoneEntityToModelConverter timezoneEntityToModelConverter;

    @Override
    public org.demicon.tech.task.d3.cloud.domain.model.Location convert(Location source) {
        org.demicon.tech.task.d3.cloud.domain.model.Location location = new org.demicon.tech.task.d3.cloud.domain.model.Location();
        location.setCoordinates(coordinatesEntityToModelConverter.convert(source.getCoordinates()));
        location.setCity(source.getCity());
        location.setCountry(source.getCountry());
        location.setPostcode(source.getPostcode());
        location.setState(source.getState());
        location.setStreet(streetEntityToModelConverter.convert(source.getStreet()));
        location.setTimezone(timezoneEntityToModelConverter.convert(source.getTimezone()));
        return location;
    }
}
