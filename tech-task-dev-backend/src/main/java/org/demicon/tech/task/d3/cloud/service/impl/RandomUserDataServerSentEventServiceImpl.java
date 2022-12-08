package org.demicon.tech.task.d3.cloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.domain.utils.UpdateFetchRandomUserEventData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class RandomUserDataServerSentEventServiceImpl {
    private ConcurrentLinkedQueue sseEmitters = new ConcurrentLinkedQueue<UpdateFetchRandomUserEventData>();
    private final RandomUserServiceImpl randomUserServiceImpl;

    Logger LOG = LoggerFactory.getLogger(RandomUserDataServerSentEventServiceImpl.class);

    public SseEmitter subscribeEvent() throws IOException {
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        UUID guid = UUID.randomUUID();
        UpdateFetchRandomUserEventData updateFetchRandomUserEventData = new UpdateFetchRandomUserEventData(guid, sseEmitter);
        sseEmitters.add(updateFetchRandomUserEventData);
        sseEmitter.send(
                SseEmitter.event().name("INIT").data(guid.toString())
        );
        sseEmitter.onCompletion(() -> {
            sseEmitters.remove(guid.toString());
            LOG.info("SseEmitter: Completed !!!");
        });
        sseEmitter.onTimeout(() -> {
            sseEmitters.remove(guid.toString());
            LOG.warn("SseEmitter: Timeout !!!");
        });
        sseEmitter.onError((ex) -> {
            sseEmitters.remove(guid.toString());
            LOG.warn("SseEmitter: Error !!!", ex);
        });

        LOG.info("SseEmitter: sent -> INIT");
        return sseEmitter;
    }

    public void dispatchEvent() throws IOException {
        LOG.info("SseEmitter: INVOKE dispatchEvent");
        UpdateFetchRandomUserEventData updateFetchRandomUserEventData = (UpdateFetchRandomUserEventData) sseEmitters.peek();
        LOG.info("updateFetchRandomUserEventData:" + updateFetchRandomUserEventData);
        if(Objects.nonNull(updateFetchRandomUserEventData)) {
            String ldt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
            updateFetchRandomUserEventData.sseEmitter().send(
                    SseEmitter.event().name("RefreshRandomUserData").data(ldt)
            );
            LOG.info("SseEmitter: sent -> RefreshRandomUserData: " + ldt);
        }
    }
}
