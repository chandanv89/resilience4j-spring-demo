package com.github.chandanv89.demo.resilience4j.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HourlyUnits {
  private String time;

  @JsonAlias("temperature_2m")
  private String temperature2m;
}
