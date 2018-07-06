package com.telerikacademy.models;

import com.telerikacademy.enumerations.TransportType;

import java.time.LocalDate;
import java.util.ArrayList;

public class Transportation extends TripActivity {
  private TransportType transportType;
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
