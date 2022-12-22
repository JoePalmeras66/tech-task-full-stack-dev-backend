package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.service.impl.GenderServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class GenderController {
    private final GenderServiceImpl genderService;

    @GetMapping("/genders")
    public CompletableFuture<Stream<String>> findAllGenders() {
        return CompletableFuture.completedFuture(this.genderService.findAllDistinct());
    }
}