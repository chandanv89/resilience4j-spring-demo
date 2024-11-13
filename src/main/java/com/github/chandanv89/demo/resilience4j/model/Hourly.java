package com.github.chandanv89.demo.resilience4j.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Hourly {
  private List<String> time;

  @JsonAlias("temperature_2m")
  private List<Double> temperature2m;
}
