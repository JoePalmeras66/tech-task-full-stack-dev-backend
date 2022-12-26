package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.LocationListEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.service.impl.LocationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/techtask/api/v1")
@RequiredArgsConstructor
public class LocationController {
    private final LocationServiceImpl locationService;
    private final LocationListEntityToResponseConverter locationListEntityToResponseConverter;

    @GetMapping("/location/countries")
    public CompletableFuture<Stream<String>> findAllCountries() {
        return CompletableFuture.completedFuture(
                this.locationService.findAllCountries()
        );
    }

    @GetMapping("/location/streets")
    public CompletableFuture<Stream<String>> findAllStreetsByCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllStreetNamesByCountry(country)
        );
    }

    @GetMapping("/location/states")
    public CompletableFuture<Stream<String>> findAllStatesByCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllStatesByCountry(country)
        );
    }

    @GetMapping("/location/cities")
    public CompletableFuture<Stream<String>> findAllCitiesByCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllCitiesByCountry(country)
        );
    }
}