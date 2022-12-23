package org.demicon.tech.task.d3.cloud.repository;

import org.demicon.tech.task.d3.cloud.entity.QStreet;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StreetRepository extends QuerydslRepository<Street, UUID> {
    QStreet qStreet = QStreet.street;
}
