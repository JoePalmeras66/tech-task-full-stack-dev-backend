package org.demicon.tech.task.d3.cloud.service;

import lombok.NonNull;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface RandomUserService {
    Page<RandomUser> findAll(String country,
                             String state,
                             String city,
                             String gender,
                             @NonNull Pageable pageable);
    Stream<RandomUser> findAll(String country,
                               String state,
                               String city,
                               String gender);
    Stream<RandomUser> findAllByLocationCountry(String country);
    Page<RandomUser> findAllByLocationCountry(@NonNull String country, @NonNull Pageable pageable);
    RandomUser save(RandomUser entity);
}
