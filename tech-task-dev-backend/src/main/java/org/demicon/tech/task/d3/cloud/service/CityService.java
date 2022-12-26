package org.demicon.tech.task.d3.cloud.service;

import java.util.stream.Stream;

public interface CityService {
    Stream<String> findAllCityDistinct();
}
