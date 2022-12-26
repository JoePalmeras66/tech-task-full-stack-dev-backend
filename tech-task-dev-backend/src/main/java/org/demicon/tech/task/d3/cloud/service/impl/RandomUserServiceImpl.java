package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.RandomUserRepository;
import org.demicon.tech.task.d3.cloud.service.RandomUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RandomUserServiceImpl implements RandomUserService {
    private final RandomUserRepository randomUserRepository;

    @Override
    @Transactional
    public Stream<RandomUser> findAllByLocationCountry(String country) {
        return this.randomUserRepository.findAllByLocationCountryOrderByCreatedOnDesc(country).stream();
    }

    @Override
    @Transactional
    public Page<RandomUser> findAllByLocationCountry(@NonNull String country, @NonNull Pageable pageable) {
        return this.randomUserRepository.findAllByLocationCountry(country, pageable);
    }

    @Override
    @Transactional
    public RandomUser save(RandomUser entity) {
        return this.randomUserRepository.save(entity);
    }
}
