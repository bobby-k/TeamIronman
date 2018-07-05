package com.telerikacademy.models;

import com.telerikacademy.enumerations.TransportType;

import java.time.LocalDate;

public class Transportation extends TripActivity {
  private TransportType transportType;

  public Transportation(String name, LocalDate startDate, LocalDate endDate) {
    super(name, startDate, endDate);
  }

  @Override
  public void printInfo() {

  }
}
