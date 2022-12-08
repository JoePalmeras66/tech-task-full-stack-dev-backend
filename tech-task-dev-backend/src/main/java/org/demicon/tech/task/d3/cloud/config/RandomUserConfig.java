package org.demicon.tech.task.d3.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;

@EnableAsync
@EnableScheduling
@Configuration
public class RandomUserConfig {
    @Value("${config.endpoint.url}")
    private String url;

    static final Logger LOG = Logger.getLogger(RandomUserConfig.class.getName());

    @Bean
    WebClient createWebClient() {
        LOG.info("WebClient initialized ...");
        return WebClient.builder()
                .baseUrl(url)
                .build();
    }
}
