package com.github.chandanv89.demo.resilience4j.configs;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@PropertySource("resilience4j.yml")
public class Resilience4jConfig {
//
//  @Bean
//  public TimeLimiterConfig timeLimiterConfig() {
//    return TimeLimiterConfig.custom()
//        .timeoutDuration(Duration.ofMillis(2000))
//        .cancelRunningFuture(false)
//        .build();
//  }
//
//  @Bean
//  public TimeLimiterRegistry timeLimiterRegistry() {
//    return TimeLimiterRegistry.of(timeLimiterConfig());
//  }
//
//  @Bean
//  public TimeLimiter timeLimiter() {
//    return TimeLimiter.of("weather-service", timeLimiterConfig());
//  }
//
//  @Bean
//  public ScheduledExecutorService scheduledExecutorService() {
//    return Executors.newScheduledThreadPool(3);
//  }
}
