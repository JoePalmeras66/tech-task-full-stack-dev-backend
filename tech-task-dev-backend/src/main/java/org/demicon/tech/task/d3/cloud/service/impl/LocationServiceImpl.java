package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.LocationRepository;
import org.demicon.tech.task.d3.cloud.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Stream<Location> findAllDistinct() {
        return this.locationRepository.findAll().stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Location::getCountry))),
                        ArrayList::new)).stream();
    }

    @Override
    @Transactional
    public Stream<Street> findAllByCountry(@NonNull String country) {
        return this.locationRepository.findAllByCountry(country).stream()
                .map(Location::getStreet);
    }
}
