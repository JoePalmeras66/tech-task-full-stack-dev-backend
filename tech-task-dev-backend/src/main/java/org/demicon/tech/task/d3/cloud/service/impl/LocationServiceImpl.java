package org.demicon.tech.task.d3.cloud.service.impl;

import com.querydsl.core.BooleanBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.LocationRepository;
import org.demicon.tech.task.d3.cloud.repository.filters.LocationFilter;
import org.demicon.tech.task.d3.cloud.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Stream<String> findAllStates(String country) {
        return this.findAll(country, null, null).stream()
                .map(Location::getState);
    }

    @Override
    @Transactional
    public Stream<String> findAllCities(String country,
                                        String state) {
        return this.findAll(country, state, null).stream()
                .map(Location::getCity);
    }

    @Override
    @Transactional
    public Stream<String> findAllStreetNames(String country,
                                             String state,
                                             String city) {
        return this.findAll(country, state, city).stream()
                .map(Location::getStreet)
                .map(Street::getName);
    }

    private List<Location> findAll(String country,
                                   String state,
                                   String city) {
        BooleanBuilder predicate = LocationFilter.filter(country, state, city);
        return this.locationRepository.findAll(predicate);
    }

    @Override
    @Transactional
    public Stream<String> findAllCountries() {
        return this.locationRepository.findAll().stream()
                .map(Location::getCountry).distinct();
    }

    @Override
    @Transactional
    public Stream<String> findAllStreetNamesByCountry(@NonNull String country) {
        return this.locationRepository.findAllByCountry(country).stream()
                .map(Location::getStreet).map(Street::getName);
    }

    @Override
    @Transactional
    public Stream<String> findAllStatesByCountry(@NonNull String country) {
        return this.locationRepository.findAllByCountry(country).stream()
                .map(Location::getState);
    }

    @Override
    @Transactional
    public Stream<String> findAllCitiesByCountry(@NonNull String country) {
        return this.locationRepository.findAllByCountry(country).stream()
                .map(Location::getCity);
    }

    @Override
    @Transactional
    public Stream<String> findAllCitiesByCountryAndState(@NonNull String country,
                                                         @NonNull String state) {
        return this.locationRepository.findAllByCountryAndState(country, state).stream()
                .map(Location::getCity);
    }

    @Override
    @Transactional
    public Stream<String> findAllStreetNamesByCountryAndStateAndCity(@NonNull String country,
                                                                     @NonNull String state,
                                                                     @NonNull String city) {
        return this.locationRepository.findAllByCountryAndStateAndCity(country, state, city).stream()
                .map(Location::getStreet)
                .map(Street::getName);
    }
}