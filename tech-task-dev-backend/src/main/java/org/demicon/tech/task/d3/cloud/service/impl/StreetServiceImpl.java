package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.Street;
import org.demicon.tech.task.d3.cloud.repository.StreetRepository;
import org.demicon.tech.task.d3.cloud.service.StreetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {
    private final StreetRepository streetRepository;

    @Override
    @Transactional
    public Stream<String> findAllStreetDistinct() {
        return this.streetRepository.findAll()
                .stream()
                .map(Street::getName)
                .distinct();
    }
}