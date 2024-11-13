package com.github.chandanv89.demo.resilience4j.service;

import com.github.chandanv89.demo.resilience4j.model.Weather;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {
  private static final String WEATHER_SERVICE = "weatherservice";
  private static final String GET_CURRENT_WEATHER_FALLBACK = "getCurrentWeatherFallback";
  private static final String WEATHER_URL = "https://api.open-meteo.com/v1/forecast?latitude=53.1408&longitude=-6.0631&hourly=temperature_2m&timezone=auto";

  private final RestTemplate restTemplate;
//  private final ScheduledExecutorService scheduler;
//  private final io.github.resilience4j.timelimiter.TimeLimiter timeLimiter;

  @CircuitBreaker(name = WEATHER_SERVICE, fallbackMethod = GET_CURRENT_WEATHER_FALLBACK)
  @Bulkhead(name = WEATHER_SERVICE, fallbackMethod = GET_CURRENT_WEATHER_FALLBACK, type = Bulkhead.Type.THREADPOOL)
  @TimeLimiter(name = WEATHER_SERVICE, fallbackMethod = GET_CURRENT_WEATHER_FALLBACK)
  public CompletableFuture<ResponseEntity<Weather>> getCurrentWeather() {
    log.info("Fetching weather data...");
    final RequestEntity<?> requestEntity = RequestEntity.get(WEATHER_URL).build();

    return CompletableFuture.supplyAsync(() -> {
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
      //return restTemplate.exchange(requestEntity, Weather.class);
      return ResponseEntity.ok(new Weather());
    });
  }

  public CompletableFuture<ResponseEntity<Weather>> getCurrentWeatherFallback(TimeoutException e) {
    log.error("{} triggered!", GET_CURRENT_WEATHER_FALLBACK, e);
    return CompletableFuture.failedFuture(e);
  }
}
