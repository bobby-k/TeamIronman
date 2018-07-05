package com.telerikacademy.models;

import java.time.LocalDate;

public class Accomodation extends TripActivity {
  private String name;

  public Accomodation(String name, LocalDate startDate, LocalDate endDate) {
    super(name, startDate, endDate);
  }

  public Accomodation(String name, LocalDate startDate, long period) {
    super(name, startDate, period);
  }

  @Override
  public void printInfo() {

  }
}
