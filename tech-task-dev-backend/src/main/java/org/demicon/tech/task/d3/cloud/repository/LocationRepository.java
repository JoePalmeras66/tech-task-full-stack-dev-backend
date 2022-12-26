package org.demicon.tech.task.d3.cloud.repository;

import lombok.NonNull;
import org.demicon.tech.task.d3.cloud.entity.Location;
import org.demicon.tech.task.d3.cloud.entity.QLocation;
import org.demicon.tech.task.d3.cloud.repository.querydsl.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LocationRepository extends QuerydslRepository<Location, UUID> {
    List<Location> findAllByCountry(@NonNull String country);
    List<Location> findAllByCountryAndState(@NonNull String country, @NonNull String state);
    List<Location> findAllByCountryAndStateAndCity(@NonNull String country, @NonNull String state, @NonNull String city);
    QLocation qLocation = QLocation.location;
}
