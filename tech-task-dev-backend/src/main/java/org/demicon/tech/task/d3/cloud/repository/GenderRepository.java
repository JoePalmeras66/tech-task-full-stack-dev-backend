package org.demicon.tech.task.d3.cloud.repository;

import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenderRepository extends QuerydslRepository<RandomUser, UUID> {
}
