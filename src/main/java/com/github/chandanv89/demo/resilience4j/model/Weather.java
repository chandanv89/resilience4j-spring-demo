package com.github.chandanv89.demo.resilience4j.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Weather {
  private Double latitude;
  private Double longitude;

  @JsonAlias("generationtime_ms")
  private BigDecimal generationtimeMs;

  @JsonAlias("utc_offset_seconds")
  private Long utcOffsetSeconds;
  private String timezone;

  @JsonAlias("timezone_abbreviation")
  private String timezoneAbbreviation;
  private Double elevation;

  @JsonAlias("hourly_units")
  private HourlyUnits hourlyUnits;
  private Hourly hourly;
}
