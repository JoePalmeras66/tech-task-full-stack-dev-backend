package org.demicon.tech.task.d3.cloud.domain.utils;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.UUID;


public record UpdateFetchRandomUserEventData(UUID uuid, SseEmitter sseEmitter) {
}
