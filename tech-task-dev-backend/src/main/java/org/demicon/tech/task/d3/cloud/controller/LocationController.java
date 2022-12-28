package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/location/countries")
    public CompletableFuture<Stream<String>> findAllCountries() {
        return CompletableFuture.completedFuture(
                this.locationService.findAllCountries()
        );
    }

    @GetMapping("/location/states")
    public CompletableFuture<Stream<String>> findAllStates(
            @RequestParam(required = false, value="country") String country) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllStates(country)
        );
    }

    @GetMapping("/location/cities")
    public CompletableFuture<Stream<String>> findAllCities(
            @RequestParam(required = false, value="country") String country,
            @RequestParam(required = false, value="state") String state) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllCities(country, state)
        );
    }

    @GetMapping("/location/streets")
    public CompletableFuture<Stream<String>> findAllStreetNames(
            @RequestParam(required = false, value="country") String country,
            @RequestParam(required = false, value="state") String state,
            @RequestParam(required = false, value="city") String city) {
        return CompletableFuture.completedFuture(
                this.locationService.findAllStreetNames(country, state, city)
        );
    }
}