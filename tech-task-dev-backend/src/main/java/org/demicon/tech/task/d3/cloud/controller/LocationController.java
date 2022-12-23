package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.LocationListEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.service.impl.LocationServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationServiceImpl locationService;
    private final LocationListEntityToResponseConverter locationListEntityToResponseConverter;

    @GetMapping("/locations")
    public CompletableFuture<Stream<String>> findAll() {
        return CompletableFuture.completedFuture(this.locationListEntityToResponseConverter.convert(
                this.locationService.findAllDistinct()
        ).map(item -> item.country()));
    }

    @GetMapping("/location/streets")
    public CompletableFuture<Stream<String>> findAllByCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllByCountry(country).map(Street::getName)
        );
    }
}