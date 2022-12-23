package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.repository.CityRepository;
import org.demicon.tech.task.d3.cloud.service.CityService;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public Stream<String> findAllCityDistinct() {
        return this.cityRepository.findAll().stream().map(Location::getCity).distinct();
    }
}
