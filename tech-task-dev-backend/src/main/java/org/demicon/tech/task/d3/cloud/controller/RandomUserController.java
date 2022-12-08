package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataListEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RandomUserController {
    private final RandomUserServiceImpl randomUserService;
    private final RandomDataListEntityToResponseConverter randomDataListEntityToResponseConverter;

    @GetMapping("/randomusers")
    public CompletableFuture<List<RandomUserResponse>> findAllByLocationCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(this.randomDataListEntityToResponseConverter.convert(
                this.randomUserService.findAllByLocationCountry(country)
         ).collect(Collectors.toList()));
    }
}
