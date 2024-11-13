package com.github.chandanv89.demo.resilience4j.controller;

import com.github.chandanv89.demo.resilience4j.model.Weather;
import com.github.chandanv89.demo.resilience4j.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherService weatherService;

  @GetMapping("")
  public CompletableFuture<ResponseEntity<Weather>> getCurrentWeather() throws Exception {
    return weatherService.getCurrentWeather();
  }
}
