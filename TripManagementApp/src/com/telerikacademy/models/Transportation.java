package com.telerikacademy.models;

import com.telerikacademy.enumerations.VehicleType;

import java.time.LocalDate;

public class Transportation extends TripActivity {
  private VehicleType transportType;
  private double distance;
  private double duration;
  private double price;


  public Transportation(String name, LocalDate startDate, LocalDate endDate) {
    super(name, startDate, endDate);
  }

  @Override
  public void printInfo() {

  }
}
