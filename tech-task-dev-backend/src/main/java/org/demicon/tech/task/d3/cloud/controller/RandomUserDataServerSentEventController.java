package org.demicon.tech.task.d3.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.service.impl.RandomUserDataServerSentEventServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@CrossOrigin
@RestController
@RequestMapping("/techtask/api/v1")
@RequiredArgsConstructor
public class RandomUserDataServerSentEventController {
    private final RandomUserDataServerSentEventServiceImpl randomUserDataServerSentEventServiceImpl;

    @GetMapping("/sse/subscribe")
    public CompletableFuture<SseEmitter> subscribe() throws IOException {
        return CompletableFuture.completedFuture(this.randomUserDataServerSentEventServiceImpl.subscribeEvent());
    }

    @GetMapping("/sse/dispatch")
    public void dispatch() throws IOException {
        this.randomUserDataServerSentEventServiceImpl.dispatchEvent();
    }
}
