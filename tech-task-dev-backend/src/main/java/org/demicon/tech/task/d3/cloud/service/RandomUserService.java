package org.demicon.tech.task.d3.cloud.service;

import org.demicon.tech.task.d3.cloud.entity.RandomUser;

import java.util.stream.Stream;

public interface RandomUserService {
    Stream<RandomUser> findAllByLocationCountry(String country);
    RandomUser save(RandomUser entity);
}
