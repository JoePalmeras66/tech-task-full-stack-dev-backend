package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataStreamEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataPageEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.task.d3.cloud.api.model.PageableRandomUserDTO;
import tech.task.d3.cloud.api.model.RandomUserDTO;

import org.springframework.http.ResponseEntity;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/techtask/api/v1")
@RequiredArgsConstructor
public class RandomUserController {
    private final RandomUserServiceImpl randomUserService;
    private final RandomDataStreamEntityToResponseConverter randomDataStreamEntityToResponseConverter;
    private final RandomDataPageEntityToResponseConverter randomDataPageEntityToResponseConverter;

    @GetMapping("/randomusers/all")
    public CompletableFuture<ResponseEntity<PageableRandomUserDTO>> findAllByLocationCountryPagination(
            @RequestParam("country") String country,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("gender") String gender,
            @PageableDefault(sort = "createdOn") Pageable pageable) {

        return CompletableFuture.completedFuture(new ResponseEntity<>(this.randomDataPageEntityToResponseConverter.convert(
                this.randomUserService.findAll(country, state, city, gender, pageable)), HttpStatus.OK)
        );
    }

    @GetMapping("/randomusers/all/stream")
    public CompletableFuture<ResponseEntity<Stream<RandomUserDTO>>> findAllByLocationCountry(
            @RequestParam("country") String country,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("gender") String gender) {
        return CompletableFuture.completedFuture(new ResponseEntity<>(this.randomDataStreamEntityToResponseConverter.convert(
                this.randomUserService.findAll(country, state, city, gender)), HttpStatus.OK)
        );
    }
}