package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.LocationListEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.service.impl.LocationServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationServiceImpl locationService;
    private final LocationListEntityToResponseConverter locationListEntityToResponseConverter;

    @GetMapping("/locations")
    public CompletableFuture<List<String>> findAll() {
        return CompletableFuture.completedFuture(this.locationListEntityToResponseConverter.convert(
                this.locationService.findAllDistinct()
        ).map(item -> item.country()).collect(Collectors.toList()));
    }
}
