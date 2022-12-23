package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.LocationRepository;
import org.demicon.tech.task.d3.cloud.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

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
}