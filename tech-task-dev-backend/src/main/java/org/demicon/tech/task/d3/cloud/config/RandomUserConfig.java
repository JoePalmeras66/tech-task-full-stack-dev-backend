package org.demicon.tech.task.d3.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@EnableAsync
@EnableScheduling
@Configuration
public class RandomUserConfig {
    @Value("${config.endpoint.url}")
    private String url;

    static final Logger LOG = LoggerFactory.getLogger(RandomUserConfig.class);

    @Bean
    WebClient createWebClient() {
        LOG.info("WebClient initialized ...");
        return WebClient.builder()
                .baseUrl(url)
                .build();
    }
}
