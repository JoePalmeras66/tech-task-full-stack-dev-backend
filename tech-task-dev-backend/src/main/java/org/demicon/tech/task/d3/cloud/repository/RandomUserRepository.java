package org.demicon.tech.task.d3.cloud.repository;

import org.demicon.tech.task.d3.cloud.entity.QRandomUser;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RandomUserRepository extends QuerydslRepository<RandomUser, UUID> {
    Streamable<RandomUser> findAllByLocationCountryOrderByCreatedOnDesc(String country);
    QRandomUser qRandomUserEntity = QRandomUser.randomUser;
}