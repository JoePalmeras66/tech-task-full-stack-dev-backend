package org.demicon.tech.task.d3.cloud.repository;

import lombok.NonNull;
import org.demicon.tech.task.d3.cloud.entity.QRandomUser;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RandomUserRepository extends QuerydslRepository<RandomUser, UUID> {
    Streamable<RandomUser> findAllByLocationCountryOrderByCreatedOnDesc(String country);
    Page<RandomUser> findAllByLocationCountry(@NonNull String country, @NonNull Pageable pageable);
    QRandomUser qRandomUserEntity = QRandomUser.randomUser;
}