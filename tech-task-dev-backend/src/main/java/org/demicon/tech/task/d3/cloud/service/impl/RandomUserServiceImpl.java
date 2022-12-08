package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.RandomUserRepository;
import org.demicon.tech.task.d3.cloud.service.RandomUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RandomUserServiceImpl implements RandomUserService {
    private final RandomUserRepository randomUserRepository;

    @Value("${config.max.users}")
    private Integer maxUsers;

    @Override
    public Stream<RandomUser> findAllByLocationCountry(String country) {
        return this.randomUserRepository.findAllByLocationCountryOrderByCreatedOnDesc(country)
                .stream().limit(this.maxUsers);
    }

    @Override
    public RandomUser save(RandomUser entity) {
        return this.randomUserRepository.save(entity);
    }
}
