package org.demicon.tech.task.d3.cloud.repository;

import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.QLocation;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends QuerydslRepository<Location, UUID> {
    QLocation qLocation = QLocation.location;
}
