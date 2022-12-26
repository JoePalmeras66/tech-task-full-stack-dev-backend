package org.demicon.tech.task.d3.cloud.service;

import java.util.stream.Stream;

public interface GenderService {
    Stream<String> findAllGenderDistinct();
}
