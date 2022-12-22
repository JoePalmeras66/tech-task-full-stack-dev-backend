package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.LocationRepository;
import org.demicon.tech.task.d3.cloud.service.StreetService;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {
    private final LocationRepository locationRepository;
    @Override
    public Stream<String> findAllStreetDistinct() {
        return this.locationRepository.findAll()
                .stream()
                .map(Location::getStreet)
                .map(Street::getName)
                .distinct();
    }
}
