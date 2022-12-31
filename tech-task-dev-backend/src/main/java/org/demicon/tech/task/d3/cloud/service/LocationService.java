package org.demicon.tech.task.d3.cloud.service;

import lombok.NonNull;
import java.util.stream.Stream;

public interface LocationService {
    Stream<String> findAllCountries(String state, String city);
    Stream<String> findAllStates(String country, String city);
    Stream<String> findAllCities(String country, String state);
    Stream<String> findAllStreetNames(String country, String state, String city);
    Stream<String> findAllStreetNamesByCountry(@NonNull String country);
    Stream<String> findAllStatesByCountry(@NonNull String country);
    Stream<String> findAllCitiesByCountry(@NonNull String country);
    Stream<String> findAllCitiesByCountryAndState(@NonNull String country, @NonNull String state);
    Stream<String> findAllStreetNamesByCountryAndStateAndCity(@NonNull String country, @NonNull String state, @NonNull String city);
}