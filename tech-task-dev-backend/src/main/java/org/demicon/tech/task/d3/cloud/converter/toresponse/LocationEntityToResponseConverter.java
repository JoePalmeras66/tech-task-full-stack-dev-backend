package org.demicon.tech.task.d3.cloud.converter.toresponse;


import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.response.LocationResponse;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationEntityToResponseConverter implements Converter<Location, LocationResponse> {
    @Override
    public LocationResponse convert(Location source) {
        return new LocationResponse(source.getCountry());
    }
}
