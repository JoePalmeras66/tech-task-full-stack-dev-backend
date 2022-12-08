package org.demicon.tech.task.d3.cloud.converter.toresponse;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.model.response.LocationResponse;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class LocationListEntityToResponseConverter implements Converter<Stream<Location>, Stream<LocationResponse>> {
    private final LocationEntityToResponseConverter locationEntityToResponseConverter;
    @Override
    public Stream<LocationResponse> convert(Stream<Location> source) {
        return source.map(item -> this.locationEntityToResponseConverter.convert(item));
    }
}
