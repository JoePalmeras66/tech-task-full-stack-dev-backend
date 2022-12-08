package org.demicon.tech.task.d3.cloud.scheduler;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.converter.toentities.RandomUserModelToEntityConverter;
import org.demicon.tech.task.d3.cloud.converter.tomodels.ResultEntityToModelConverter;
import org.demicon.tech.task.d3.cloud.domain.model.RandomUserData;
import org.demicon.tech.task.d3.cloud.domain.model.Result;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserDataServerSentEventServiceImpl;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomUserScheduler {
    @Value("${config.jobs.enabled}")
    private boolean isEnabled;

    private final WebClient client;
    private final RandomUserServiceImpl randomUserServiceImpl;
    private final RandomUserModelToEntityConverter randomUserModelToEntityConverter;
    private final ResultEntityToModelConverter resultEntityToModelConverter;
    private final RandomUserDataServerSentEventServiceImpl randomUserDataServerSentEventServiceImpl;

    static final Logger LOG = LoggerFactory.getLogger(RandomUserScheduler.class);

    @Async
    @Scheduled(fixedRateString = "${config.fixed.rate}")
    public void fetchCurrentRandomUserData() throws Exception {
        if(this.isEnabled) {
            LOG.info("Fetch RandomUser at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

            Mono<RandomUserData> object = Optional.of(client
                            .get()
                            .uri("/api")
                            .retrieve()
                            .bodyToMono(RandomUserData.class))
                    .orElseThrow();

            object.subscribe(item -> {
                RandomUser randomUser = Optional.of(this.randomUserServiceImpl
                        .save(randomUserModelToEntityConverter.convert(item))
                ).orElseThrow();

                LOG.info("Successfully fetched and stored RandomUser: "+ randomUser.toString());
            });

            /*
            *     Dispatch Server-Side-Event
            *     Client can listen with EventSource to dispatch
            * */
            randomUserDataServerSentEventServiceImpl.dispatchEvent();
        }
    }
}