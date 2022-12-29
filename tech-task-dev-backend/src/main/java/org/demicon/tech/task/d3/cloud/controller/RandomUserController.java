package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataStreamEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.converter.toresponse.RandomDataPageEntityToResponseConverter;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import tech.task.d3.cloud.api.RandomusersApi;
import tech.task.d3.cloud.api.model.PageableRandomUserDTO;
import tech.task.d3.cloud.api.model.RandomUserDTO;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RandomUserController implements RandomusersApi {
    private final RandomUserServiceImpl randomUserService;
    private final RandomDataStreamEntityToResponseConverter randomDataStreamEntityToResponseConverter;
    private final RandomDataPageEntityToResponseConverter randomDataPageEntityToResponseConverter;

    @Override
    public CompletableFuture<ResponseEntity<PageableRandomUserDTO>> getRandomUsers(
            @Valid String country,
            @Valid String state,
            @Valid String city,
            @Valid String gender,
            @Valid Integer page,
            @Valid Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdOn");
        return CompletableFuture.completedFuture(new ResponseEntity<>(this.randomDataPageEntityToResponseConverter.convert(
                this.randomUserService.findAll(country, state, city, gender, pageable)), HttpStatus.OK)
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<List<RandomUserDTO>>> getStreamRandomUsers(
            @Valid String country,
            @Valid String state,
            @Valid String city,
            @Valid String gender) {
        return CompletableFuture.completedFuture(new ResponseEntity<>(
                        this.randomDataStreamEntityToResponseConverter.convert(
                                this.randomUserService.findAll(country, state, city, gender)
                        ).collect(Collectors.toList()), HttpStatus.OK
                )
        );
    }
}