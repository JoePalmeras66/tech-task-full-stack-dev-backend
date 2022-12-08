package org.demicon.tech.task.d3.cloud.service;

import org.demicon.tech.task.d3.cloud.entity.Location;

import java.util.stream.Stream;

public interface LocationService {
    Stream<Location> findAllDistinct();
}
