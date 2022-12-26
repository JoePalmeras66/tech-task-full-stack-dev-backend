package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.service.impl.StreetServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StreetController {
    private final StreetServiceImpl streetServiceImpl;

    @GetMapping("/streets")
    public CompletableFuture<Stream<String>> findAll() {
        return CompletableFuture.completedFuture(this.streetServiceImpl.findAllStreetDistinct());
    }
}
