package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataStreamEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataPageEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/randomusers")
@RequiredArgsConstructor
public class RandomUserController {
    private final RandomUserServiceImpl randomUserService;
    private final RandomDataStreamEntityToResponseConverter randomDataStreamEntityToResponseConverter;
    private final RandomDataPageEntityToResponseConverter randomDataPageEntityToResponseConverter;

    @GetMapping("/all")
    public CompletableFuture<Page<RandomUserResponse>> findAllByLocationCountry(@RequestParam("country") String country,
                                                                                @PageableDefault(sort = "createdOn") Pageable pageable) {
        return CompletableFuture.completedFuture(this.randomDataPageEntityToResponseConverter.convert(
                this.randomUserService.findAllByLocationCountry(country, pageable))
        );
    }

    @GetMapping("/all/stream")
    public CompletableFuture<Stream<RandomUserResponse>> findAllByLocationCountry(@RequestParam("country") String country) {
        return CompletableFuture.completedFuture(this.randomDataStreamEntityToResponseConverter.convert(
                this.randomUserService.findAllByLocationCountry(country)
         ));
    }
}