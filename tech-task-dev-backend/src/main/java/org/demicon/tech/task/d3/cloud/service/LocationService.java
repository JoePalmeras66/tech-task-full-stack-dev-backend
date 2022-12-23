package org.demicon.tech.task.d3.cloud.service;

import lombok.NonNull;

import java.util.stream.Stream;

public interface LocationService {
    Stream<String> findAllCountries();
    Stream<String> findAllStreetNamesByCountry(@NonNull String country);
    Stream<String> findAllStatesByCountry(@NonNull String country);
    Stream<String> findAllCitiesByCountry(@NonNull String country);
}