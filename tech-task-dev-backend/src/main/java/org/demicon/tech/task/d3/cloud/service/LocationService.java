package org.demicon.tech.task.d3.cloud.service;

import lombok.NonNull;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;

import java.util.stream.Stream;

public interface LocationService {
    Stream<Location> findAllDistinct();
    Stream<Street> findAllByCountry(@NonNull String country);
}
