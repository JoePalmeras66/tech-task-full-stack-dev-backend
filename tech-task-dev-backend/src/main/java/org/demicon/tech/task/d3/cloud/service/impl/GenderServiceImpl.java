package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.repository.GenderRepository;
import org.demicon.tech.task.d3.cloud.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {
    private final GenderRepository genderRepository;
    @Override
    public Stream<String> findAllDistinct() {
        return this.genderRepository.findAll().stream().map(RandomUser::getGender).distinct();
    }
}
